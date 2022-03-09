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
    class ResultType{
        int sum;
        int max;
        public ResultType(int v){
            sum = v;
            max = Integer.MIN_VALUE;
        }
    }
    public int maxPathSum(TreeNode root) {
        ResultType res = sum(root);
        return res.max;
    }
    
    ResultType sum(TreeNode root){
        if(root == null) return new ResultType(0);
        ResultType left = sum(root.left);
        ResultType right = sum(root.right);
        int l = Math.max(left.sum,0), r = Math.max(0, right.sum);
        int v = l + r +root.val;
        int m = Math.max(v, Math.max(left.max, right.max));
        ResultType res = new ResultType(Math.max(l, r)+root.val);
        res.max = m;
        return res;
    }
    
}