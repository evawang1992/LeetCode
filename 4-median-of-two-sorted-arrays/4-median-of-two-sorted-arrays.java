class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
int imin = 0, imax = n, halfLength = (m + n + 1) / 2;
        double leftmax = 0; double rightmin = 0;
        if(n > m) return findMedianSortedArrays(nums2, nums1);
        int i = 0, j = 0;
        while(imin <= imax){
            i = (imin + imax) / 2;
            j = halfLength - i;
            if(i < n && j > 0 && nums2[j-1] > nums1[i]){
                imin = i + 1;
            }
            else if(i > 0 && j < m &&  nums1[i - 1] > nums2[j]){
                imax = i - 1;
            }

            else{
                
                if(i == 0) leftmax = nums2[j-1];
                else if(j == 0) leftmax = nums1[i-1];
                else leftmax = Math.max(nums1[i-1], nums2[j-1]);
                if((n+m)%2 == 1) return leftmax;
                
                break;
            }
        }
        
        if(i == n) rightmin = nums2[j];
        else if(j == m) rightmin = nums1[i];
        else rightmin = Math.min(nums1[i], nums2[j]);
        return (rightmin + leftmax) / 2;
    }
}