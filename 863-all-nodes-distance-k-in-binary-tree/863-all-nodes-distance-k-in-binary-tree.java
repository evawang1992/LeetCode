/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> dis = new HashMap<>();
        length(root, target, dis);
        dfs(res, dis, root, 0, k);
        return res;
    }
    int length(TreeNode root, TreeNode target, Map<Integer, Integer> map){
        if(root == null) return -1;
        if(root == target){
            map.put(root.val, 0);
            return 0;
        }
        int left = length(root.left, target, map);
        if(left >= 0){
            map.put(root.val, left+1);
            return left+1;
        }
        int right = length(root.right, target, map);
        if(right >= 0){
            map.put(root.val, right+1);
            return right+1;
        }
        return -1;   
    }
    void dfs(List<Integer> res, Map<Integer, Integer> map, TreeNode root, int length, int k){
        if(root == null) return;
        if(map.containsKey(root.val)) {
            length = map.get(root.val);
        }
        if(k == length) 
        res.add(root.val);
       dfs(res, map, root.left, length+1,k);
            dfs(res, map, root.right, length+1,k);
    }
}