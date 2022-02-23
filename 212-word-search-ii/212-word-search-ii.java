class Solution {
    class Trie{
        String word;
        Trie[] children= new Trie[26];
 
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board == null || board.length == 0) return result;
        Trie root = new Trie();
        buildTrie(words, root);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, result, i, j);
            }
        }
        return result;
    }
    void dfs(char[][] board, Trie root, List<String> result, int x, int y){
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y]=='#'){
            return;
        }
        char c = board[x][y];
        root = root.children[c-'a'];
        if(root == null) return;
        board[x][y] =  '#';
        if(root.word !=null) {
            result.add(root.word);
            root.word = null;
        }
        dfs(board, root, result, x-1, y);
        dfs(board, root, result, x+1, y);
        dfs(board, root, result, x, y-1);
        dfs(board, root, result, x, y+1);
        board[x][y] = c;
        
        
    }
    void buildTrie(String[] words, Trie root){
        for(String w : words){
            Trie cursor = root;
            for(char c : w.toCharArray()){
                 
                if(cursor.children[c-'a'] ==null){
                    cursor.children[c-'a'] = new Trie();
                }
                cursor = cursor.children[c-'a'];
            }
           cursor.word = w;
        }
    }
}