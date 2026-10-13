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
        if (head == null || head.next == null) {
            return;
        }

        // 1,2,3,4,5,6 - loop stops when fast.next.next is null
        //1,2,3,4,5 - loop stops when fast.next is null
        //both stops at slow = 3; so that first half is same for both = 1,2,3
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half 
        //slow is 3, so we move to the second half starting with 4
        ListNode prev = null;
        //curr = 4
        ListNode curr = slow.next;
        slow.next = null; // Disconnect the first half from the second half

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //prev has the head of the second half

        // 3. Interleave/merge the two lists
        ListNode first = head;
        ListNode second = prev;

        //1,2,3 & 6,5,4 == loop ends when both first and second are null
        //1,2,3 & 6,5 == loop ends when second is null, but first will have value that we already appended
        //In each step we do first->second->firstNext
        //Meaning, we already assign the firstNext to result before the loop starts again. So if second is null, it indicates we exhausted all values.

        while (second != null) {
            ListNode nextFirst = first.next;//2
            ListNode nextSecond = second.next;//5

            first.next = second;
            second.next = nextFirst;

            first = nextFirst;
            second = nextSecond;
        }
    }
}