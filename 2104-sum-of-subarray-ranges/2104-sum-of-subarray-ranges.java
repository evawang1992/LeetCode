class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        int n = nums.length;
        for(int i = 0; i <=n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > (i == n ? Integer.MIN_VALUE : nums[i])){
                int largerNumInd = stack.pop();
                int lessNumInd = stack.isEmpty() ? -1 : stack.peek();
                res -= (long)nums[largerNumInd] * (i-largerNumInd) * (largerNumInd-lessNumInd);
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i <=n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < (i == n ? Integer.MAX_VALUE : nums[i])){
                int largerNumInd = stack.pop();
                int lessNumInd = stack.isEmpty() ? -1 : stack.peek();
                res += (long)nums[largerNumInd] * (i-largerNumInd) * (largerNumInd-lessNumInd);
            }
            stack.push(i);
        }
        return res;
    }
}