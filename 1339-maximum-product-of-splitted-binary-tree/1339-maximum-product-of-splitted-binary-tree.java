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
    long total, max = 0;
    public int maxProduct(TreeNode root) {
        total = s(root);
        s(root);
        return (int)(max%((int)(1e9+7)));
    }
    long s(TreeNode root){
        if(root == null) return 0;
        long res = root.val + s(root.left) + s(root.right);
        max = Math.max(max, res*(total - res));
        return res;
    }
}