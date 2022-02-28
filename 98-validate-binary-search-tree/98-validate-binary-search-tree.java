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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode traverse = root;
        TreeNode pre = null;
        while(traverse != null || !stack.isEmpty()){
            while(traverse != null) {
                stack.push(traverse);
                traverse= traverse.left;
                
            }
            traverse = stack.pop();
            if(pre != null && pre.val >= traverse.val) return false;
            pre = traverse;
            traverse = traverse.right;
        }
        return true;
    }
}