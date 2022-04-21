class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = new ArrayList<>();
        helper(s, wordDict, res, new ArrayList<>(), new HashSet<>());
        List<String> words = new ArrayList<>();
        for(List<String> r: res){
            StringBuilder sb = new StringBuilder();
            for(String str : r){
                sb.append(str+" ");
            }
            words.add(sb.toString().trim());
        }
        return words;
    }
    void helper(String s, List<String> wordDict, List<List<String>> res, List<String> list, Set<String> visited){
        if(s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // if(visited.contains(s)) return;
        // visited.add(s);
            for(String w : wordDict){
                if(s.startsWith(w)){
                    list.add(w);
                    helper(s.substring(w.length()), wordDict, res, list, visited);
                    list.remove(list.size()-1);
                }
            }
        
    }
}