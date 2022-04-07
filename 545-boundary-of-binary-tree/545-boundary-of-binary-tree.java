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
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        lefttree(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        righttree(root.right, res);
        
        return res;
    }
    void lefttree(TreeNode root, List<Integer> res){
        if(root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if(root.left == null){
            lefttree(root.right, res); 
        }
        else lefttree(root.left, res);
    }
        void righttree(TreeNode root, List<Integer> res){
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.right == null){
            righttree(root.left, res); 
        }
        else righttree(root.right, res);
    res.add(root.val);
        }
    void leaves(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left, res);
        leaves(root.right, res);
        
    }
}