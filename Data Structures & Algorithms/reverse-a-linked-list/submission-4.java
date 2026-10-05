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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save next node
            curr.next = prev;               // 2. Reverse current node's pointer
            prev = curr;                    // 3. Move prev one step forward
            curr = nextTemp;                // 4. Move curr one step forward
        }

        return prev; // prev is now pointing to the new head
    }
}