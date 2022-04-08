class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
   
        int count = 0;
        for(int i : time){
            Integer n = map.get((60-i%60)%60);
            if(n!=null){
            count+= (int)n;
            }
            map.put(i%60, map.getOrDefault(i%60, 0)+1);
        }
        return count;
    }
}