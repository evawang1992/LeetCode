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
    int val;
    int count;
    public int kthSmallest(TreeNode root, int k) {

        val = 0;
        count = k;
        helper(root);
        return val;
    }
    void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(--count == 0) {
            val = root.val;
            return;
        }
        helper(root.right);
    }
}