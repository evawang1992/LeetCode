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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = Integer.MIN_VALUE;
        sum(root);
        return max;
    }
    int sum(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(0, sum(root.left)), r = Math.max(0, sum(root.right));
        int total = l+r+root.val;
        if(total > max) max = total;
        return Math.max(l, r)+root.val;
    }
}