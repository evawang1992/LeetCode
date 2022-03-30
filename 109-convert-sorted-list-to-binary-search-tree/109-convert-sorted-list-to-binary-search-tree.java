/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode h = head;
        int size = 0;
        node = head;
        while(h != null){
            h = h.next;
            size++;
        }
        return sort(0, size-1);
    }
    TreeNode sort(int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode left = sort(start,mid-1);
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = left;
        node = node.next;
        TreeNode right = sort(mid+1, end);
        newNode.right = right;
        return newNode;
    }
}