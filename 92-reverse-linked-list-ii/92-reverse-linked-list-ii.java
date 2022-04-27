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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode leftprev = dummy;
        
        // Read node at position left
        for(int i = 0; i < left-1; i++){
            leftprev = curr;
            curr = curr.next;
        }
        
        // Now curr = left, leftprev - node before left
        // reverse left to right
        ListNode prev = null;
        for(int i = left; i < right+1; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        leftprev.next.next = curr; // Fix tail
        leftprev.next = prev; // Fix intermediate head
        
        return dummy.next;
    }
}