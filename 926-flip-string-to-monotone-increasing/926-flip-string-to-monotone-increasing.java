class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int flips = 0, ones = 0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                flips = Math.min(flips+1, ones);
            }
            else ones++;
        }
        return flips;
    }
}