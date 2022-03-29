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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return traverse(root)[2];
        
    }
    int[] traverse(TreeNode root){
        if(root == null) return new int[]{Integer.MAX_VALUE, -1, -1};
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int min = Math.min(root.val, Math.min(left[0], right[0]));
        int max = Math.max(root.val, Math.max(left[1], right[1]));
        int maxDis = Math.max(Math.max(Math.abs(root.val-min), Math.abs(root.val-max)), Math.max(left[2], right[2]));
        return new int[]{min, max, maxDis};

    }
}