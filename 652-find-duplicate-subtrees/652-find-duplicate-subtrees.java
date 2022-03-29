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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null) return res;
        serialize(root, new HashMap<>(), res);
        return res;
        
    }
    String serialize(TreeNode root, Map<String, Integer> map, List<TreeNode> res){
        if(root == null) return "X,";
        String s = root.val + ","+serialize(root.left, map, res) + serialize(root.right, map, res);
        map.put(s, map.getOrDefault(s, 0)+1);
        if(map.get(s) == 2) res.add(root);
        return s;
    }
}