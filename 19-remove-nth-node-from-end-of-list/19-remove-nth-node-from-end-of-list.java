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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode tail = dummy;
        ListNode curr = head;
        
        while(n > 0) {
            n--;
            curr = curr.next;
        }
        
        while(curr != null){
            curr = curr.next;
            tail = tail.next;
        }
        
        tail.next = tail.next.next;
        
        return dummy.next;
    }
}