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

    
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        return max(root)[2];
    }
    
    int[] max(TreeNode root){
        if(root == null) return new int[]{-1,-1,-1};

        int[] left = max(root.left), right = max(root.right);
        int res = Math.max(Math.max(left[1],right[0])+1, Math.max(left[2],right[2]));
        return new int[]{left[1]+1, right[0]+1, res};

    }
}