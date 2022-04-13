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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode cur = head;
        int len = 1;
        ListNode tail = head;
        while(cur.next!= null){
            cur = cur.next;
            len++;
        }
        
        k = len - k% len;
        cur.next= head;
        cur = head;
        while(cur != null && --k >0){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
    
}