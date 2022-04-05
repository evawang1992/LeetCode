class FileSystem {
class FileNode{
    StringBuilder file;
    TreeMap<String, FileNode> children;
    String name;
    boolean isFile;
    FileNode(String v){
        name = v;
        file = new StringBuilder();
        isFile = file.length() > 0;
        children = new TreeMap<>();
    }
    List<String> getList(){
        List<String> list= new ArrayList<>();
        if(isFile){
            list.add(name);
        }
        else list.addAll(children.keySet());
        
        return list;
    }
    void addContent(String s){
        file.append(s);
        isFile = true;
    }
    String getContent(){
        return file.toString();
    }
}
    FileNode root;
    public FileSystem() {
        root = new FileNode("");
    }
    
    private FileNode findNode(String path){
        String[] parr = path.split("/");
        
        FileNode cur = root;
        for(String p: parr){
            if(p.length() == 0) continue;
            cur.children.putIfAbsent(p, new FileNode(p));
            cur = cur.children.get(p);
            if(cur.isFile) break;
        }
        return cur;
    }
    public List<String> ls(String path) {

        return findNode(path).getList();
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
        
    }
    
    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */