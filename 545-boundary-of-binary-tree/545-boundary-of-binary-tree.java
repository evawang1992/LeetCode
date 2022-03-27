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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;
        nodes.add(root.val);
        leftBoundary(nodes, root.left);
        addLeaves(nodes, root.left);
        addLeaves(nodes, root.right);
        rightBoundary(nodes, root.right);

        return nodes;
    }
    void leftBoundary(List<Integer> list, TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        list.add(root.val);
        if(root.left == null) leftBoundary(list, root.right);
        else leftBoundary(list, root.left);
        
    }
        void rightBoundary(List<Integer> list, TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.right == null) rightBoundary(list, root.left);
        else rightBoundary(list, root.right);
        list.add(root.val);
    }
    void addLeaves(List<Integer> list, TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        addLeaves(list, root.left);
        addLeaves(list, root.right);
    }
}