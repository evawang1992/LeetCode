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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);
        for(ListNode ln : lists){
            while(ln != null){
                pq.offer(ln);
                ln = ln.next;
            }
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            cur.next = n;
            cur = n;
        }
        cur.next = null;
        return dummy.next;
        
    }
}