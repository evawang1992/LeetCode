class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q  = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        
        for(int i = 0; i < nums.length; i++){
            while(!q.isEmpty() && q.peekFirst() <i - k+1){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
             q.offer(i);
            if(i >= k-1) res[i-k+1] = nums[q.peekFirst()];
           
        }
        return res;
    }
}