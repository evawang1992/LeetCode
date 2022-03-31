/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0;
        return calc(root)[2];
    }
    
    double[] calc(TreeNode root){
        if(root == null) return new double []{0, 0, 0};
        double [] left = calc(root.left) , right = calc(root.right);
        double count = left[0]+right[0]+1, total = left[1]+right[1]+root.val;
        double average = total/count; average = Math.max(average, Math.max(left[2], right[2]));
        return new double[]{count, total, average};
    }
}