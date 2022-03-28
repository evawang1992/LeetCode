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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        return travel(root, new HashSet<>(), k);
    }
    boolean travel(TreeNode root, Set<Integer> set, int k){
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return travel(root.left, set, k) || travel(root.right, set, k);
    }
}