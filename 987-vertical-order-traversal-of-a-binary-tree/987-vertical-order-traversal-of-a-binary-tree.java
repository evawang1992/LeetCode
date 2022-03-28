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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        update(map, root, 0,0);
        for(Map<Integer,List<Integer>> inMap : map.values()){
            List<Integer> cols = new ArrayList<>();
            for(List<Integer> list:inMap.values()){
                Collections.sort(list);
                cols.addAll(list);
            }
            res.add(cols);
        }
        return res;
    }
    void update(TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, TreeNode root, int col, int row){
        if(root == null) return;
        if(!map.containsKey(col)) map.put(col, new TreeMap<>());
        if(!map.get(col).containsKey(row)) map.get(col).put(row, new ArrayList<>());
        map.get(col).get(row).add(root.val);
        // map.computeIfAbsent(col, k->new HashMap<>()).computeIfAbsent(row, n-> new ArrayList<>()).add(root.val);
        update(map, root.left, col-1,row+1);
        update(map, root.right, col+1, row+1);
    }
}