class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> res = new ArrayList<>();
                List<String> numres = new ArrayList<>();

        for(String log : logs){
            String s = log.split(" ")[1];
            if(s.charAt(0) <='9' && s.charAt(0) >= '0') numres.add(log);
            else res.add(log);
        }
        res.sort((String a, String b)-> getContent(a).equals(getContent(b))? a.split(" ")[0].compareTo(b.split(" ")[0]) : getContent(a).compareTo(getContent(b)));
        res.addAll(numres);
        String[] ress = new String[logs.length];
        int i = 0;
        for(String r : res){
            ress[i++] = r;
        }
        return ress; 
    }
                 String getContent(String a){
                     return a.substring(a.indexOf(" ")+1, a.length());
                 }
}