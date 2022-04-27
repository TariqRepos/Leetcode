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
    // Iterative T: O(n) S: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    
//     // Recursive T: O(n) S: O(n)
//     public ListNode reverseList(ListNode head) {
//         if(head == null)
//             return null;
        
//         ListNode newhead = head;
//         if(head.next != null){
//             newhead = reverseList(head.next);
//             head.next.next = head;
//         }
//         head.next = null;
        
//         return newhead;
//     }
}