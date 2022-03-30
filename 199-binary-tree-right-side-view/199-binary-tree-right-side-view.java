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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        addRightSideView(root, res, 0);
        return res;
    }
    
    void addRightSideView(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        if(level+1 > list.size())list.add(root.val);
        addRightSideView(root.right, list, level+1);
                addRightSideView(root.left, list, level+1);

    }
}