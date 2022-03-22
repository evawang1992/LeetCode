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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(res, root);
        return res;
    }
    
    int height(List<List<Integer>> res, TreeNode root){
        if(root == null) return 0;
        int h = Math.max(height(res, root.left), height(res, root.right));
        if(h +1> res.size()) res.add(new ArrayList<>());
        res.get(h).add(root.val);
        return h+1;
    }
}