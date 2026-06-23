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
        ListNode left = head;
        ListNode right = head;
  
        while (n > 0) {
            right = right.next;
            n--;
        }
    if (right == null) {
    return head.next; // remove the head node
}
        ListNode prev= left;
        while(right!=null){
            prev= left;
            left = left.next;//3
            right= right.next;//last node
        }

        prev.next = left.next;
        return head;




    }
}
