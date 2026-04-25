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
    public void reorderList(ListNode head) {
        int size = 0;
        ListNode sizeNode = head;
        while (sizeNode != null) {
            if (sizeNode != null)
                size++;
            sizeNode = sizeNode.next;
        }

        int mid = (size+1) / 2;
        int index = 1;
        ListNode midNode = head;
        while (midNode != null) {
            if (index == mid) {
                break;
            }

            index++;
            midNode = midNode.next;
        }

        ListNode prev = null;
        ListNode after = null;
        ListNode curr = midNode.next;
        midNode.next = null;

        while (curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        ListNode first = head;
        ListNode second = prev;
        //first = 2, 4
        //second = 6,8
        //list 2->6->4

        while (first != null && second != null) {
            ListNode firstNextValCapture = first.next; //null
            ListNode secondNextValCapture = second.next; //null

            first.next = second;
            second.next = firstNextValCapture;

            first = firstNextValCapture;
            second = secondNextValCapture;
        }
    }
}
