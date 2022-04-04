class Solution {
    public int minSwaps(int[] data) {
        int n = 0;
        for(int i : data){
            if(i> 0)
            n++;
        }
        int max = 0, count = 0;
        for(int i = 0; i< n; i++){
            if(data[i] > 0) count++;
        }
        
        max = count;
        
        for(int j = n; j < data.length; j++){
            if(data[j] > 0) count++;
            if(data[j-n] > 0) count--;
            // System.out.println(count);
            max = Math.max(max, count);
        }
        
        return n-max;
    }
}