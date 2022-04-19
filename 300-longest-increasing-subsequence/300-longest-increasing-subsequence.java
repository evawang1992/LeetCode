class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for(int x : nums){
            int i = 0, j = size;
            while(i != j){
                int mid = (i+j)/2;
                if(tail[mid] < x){
                    i = mid+1;
                }
                else j = mid;
            }
            tail[i] = x;
            if(i == size)size++;
        }
        return size;
        
    }
}