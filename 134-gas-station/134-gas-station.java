class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, cur = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            int dif = gas[i] - cost[i];
            total += dif;
            cur += dif;
            if(cur < 0){
                start= i+1;
                cur = 0;
            }
            
        }
        return total < 0 ? -1 : start;
    }
}