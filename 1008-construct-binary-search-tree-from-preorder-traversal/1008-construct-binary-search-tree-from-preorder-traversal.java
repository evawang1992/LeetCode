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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        Queue<Integer> q = new LinkedList<>();
    for(int i : preorder) {
        q.offer(i);
    }
        return buildBst(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    TreeNode buildBst(Queue<Integer> q, int lower, int higher){
        if(q.isEmpty() || (q.peek() < lower || q.peek() > higher)) return null;
        int n = q.poll();
        TreeNode node = new TreeNode(n);
        node.left = buildBst(q, lower, n);
        node.right = buildBst(q, n, higher);
        return node;
    }
}