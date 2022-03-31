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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> stack1 = new Stack<>();
                Stack<TreeNode> stack2 = new Stack<>();
        while((root1 != null || !stack1.isEmpty()) && (root2 != null || !stack2.isEmpty())){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                stack2.push(root2);
                root2 = root2.right;
            }
            int a = stack1.peek().val;
            int b = stack2.peek().val;
            if(a + b == target) return true;
            
            if(a + b < target){
                TreeNode t = stack1.pop();
                root1 = t.right;
            }
            else {
                TreeNode t = stack2.pop();
                root2 = t.left;
            }
        }
        return false;
        

    }
}