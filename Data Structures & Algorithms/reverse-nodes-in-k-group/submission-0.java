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
        ListNode dummy = new ListNode(0, head); // 1. Attach head to dummy!
        ListNode groupPrev = dummy;

        while (true) {
            // 2. Check if k nodes exist ahead of groupPrev
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next; // Fewer than k nodes left -> leave as-is and return!
                }
            }

            ListNode nextGroupHead = kth.next; // Save start of next group
            ListNode groupStart = groupPrev.next; // Will become the NEW TAIL after reverse()

            // 3. Sever, reverse, and reconnect
            kth.next = null;
            groupPrev.next = reverse(groupStart); // Connect previous group to new head (kth)
            groupStart.next = nextGroupHead;      // Connect new tail to remainder of list

            // 4. Move groupPrev to the node right before the next group (which is groupStart!)
            groupPrev = groupStart;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
        }
        return prev;
    }
}