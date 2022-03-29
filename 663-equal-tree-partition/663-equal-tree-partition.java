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
   
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = sum(root,map);
        if(sum == 0) return map.getOrDefault(sum, 0) > 1;
        return sum%2 == 0 && map.containsKey(sum/2);
    }
    int sum(TreeNode root, Map<Integer, Integer> map){
        if(root == null) return 0;
        int s = root.val + sum(root.left, map) + sum(root.right, map);
        map.put(s, map.getOrDefault(s,0)+1);
        return s;
    }
}