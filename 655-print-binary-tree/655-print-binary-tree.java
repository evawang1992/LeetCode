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
    public List<List<String>> printTree(TreeNode root) {
        int row = height(root);
        int col = (int)Math.pow(2,row)-1;
        
        List<List<String>> res = new ArrayList<>();
        List<String> r = new ArrayList<>();
        for(int i = 0; i < col; i++){
            r.add("");
        }
        for(int j = 0; j < row; j ++){
            res.add(new ArrayList<>(r));
        }
        print(root, res, 0, 0, col-1);
        return res;
    }
    
    void print(TreeNode root, List<List<String>> res, int row,  int start, int end){
        if(root == null || start > end) return;
        int p = start + (end-start)/2;
        // System.out.println(p);
        res.get(row).set(p,""+root.val);
        print(root.left, res, row+1, start, p-1);
        print(root.right, res, row+1, p+1, end);
    }
    int height(TreeNode root){
        if(root == null) return 0;
        int h = Math.max(height(root.left), height(root.right));
        return h+1;
    }
}