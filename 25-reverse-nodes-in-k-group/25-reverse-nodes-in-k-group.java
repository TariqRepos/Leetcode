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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode ktail = dummy;
        ListNode curr = head;
        ListNode right = head;
        
        
        while(true){
            int count = 0;
            
            // Check if enough nodes to reverse
            while(right != null && count < k){
                count++;
                right = right.next;
            }
            
            // Reverse
            if(count == k){
                ListNode prev = null;
                for(int i=0; i<k; i++){
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                
                // Update tail
                ListNode tail = ktail.next;
                ktail.next.next = curr;
                ktail.next = prev;
                ktail = tail;

            }
            
            // Retrun if cant reverse
            else{
                return dummy.next;
            }
        }
    }
}