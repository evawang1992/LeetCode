class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        int half = (m+n+1)/2;
        int left = 0, right = m;
        double leftmax= 0, rightmin = nums2[n-1];
        int mid = (left+right)/2;
            int nmid= half - mid;
        while(left <= right){
             mid = (left+right)/2;
             nmid= half - mid;
            if(mid > 0 && nmid < n && nums1[mid-1] > nums2[nmid]){
                right = mid-1;
            }
            else if(nmid > 0 && mid < m && nums1[mid] < nums2[nmid -1]){
                left = mid+1;
            }
            else {
                if(mid == 0) leftmax = nums2[nmid-1];
                else if(nmid == 0) leftmax = nums1[mid-1];
                else leftmax = Math.max(nums1[mid-1],nums2[nmid-1]);
                if((m+n)%2 == 1) return leftmax;
                break;
            }
        }
        if(mid == m)rightmin = nums2[nmid];
        else if (nmid == n) rightmin = nums1[mid];
        else rightmin = Math.min(nums1[mid], nums2[nmid]);
        return (leftmax+rightmin)/2;
    }
}