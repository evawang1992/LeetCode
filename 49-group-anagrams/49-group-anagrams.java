class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chararr = s.toCharArray();
            Arrays.sort(chararr);
            
            map.computeIfAbsent(String.valueOf(chararr), k->new ArrayList<>()).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> r : map.values()){
            res.add(r);
        }
        return res;
    }
}