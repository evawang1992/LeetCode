class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int rightmax = height[n-1];
        int leftmax = height[0];
        int res = 0;
        int left = 0, right = n-1;
        while(left < right){
            if(height[left] <= height[right]){
                
                leftmax = Math.max(leftmax, height[left]);
                res+= leftmax - height[left++];
            }
            else {
                
                rightmax = Math.max(rightmax, height[right]);
                res += rightmax -height[right--];
            }
        }
        return res;

        
    }
}