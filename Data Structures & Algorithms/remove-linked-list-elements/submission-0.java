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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);

        //now let dummy point at head:
        dummy.next = head;

        //now i will create a traversal pointer:
        ListNode curr = dummy;

        // -1->2->1->4->1->2->3

        while (curr != null) {
            if (curr.next != null && curr.next.val == val) {
               curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        } 

        return dummy.next;
    }
}