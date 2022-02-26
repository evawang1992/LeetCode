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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return btree(preorder, inorder, 0, inorder.length-1, 0);
    }
    TreeNode btree(int[] preorder, int[] inorder, int instart, int inend, int prep){
        if(prep >= preorder.length || instart > inend) return null;
        int ind = 0;
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == preorder[prep]) {
                ind = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[prep]);
        root.left = btree(preorder, inorder, instart, ind-1, prep+1);
        root.right = btree(preorder, inorder, ind+1, inend, prep+ind-instart+1);
        return root;
        
    }
}