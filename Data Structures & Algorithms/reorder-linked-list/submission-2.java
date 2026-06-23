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
        // 1 2 3 4 5 6 -> 1 2 3 ; 4 5 6
        ListNode slow = head; 
        ListNode fast = head; //end
        //to find the mid and the end
        while(fast!=null && fast.next !=null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        //reverse the second half
        // 4 5 6 
        ListNode prev = null;
        ListNode curr = slow.next;//4
        slow.next = null; // Disconnect the first half from the second

        while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }// 6 5 4

        ListNode headOfreversed = prev;
        ListNode headOfforward = head;

        while(headOfreversed!=null ){
            ListNode nextInForward = headOfforward.next;
            ListNode nextInReverse = headOfreversed.next;
            headOfforward.next = headOfreversed;
            headOfreversed.next = nextInForward;
            headOfforward = nextInForward;
            headOfreversed = nextInReverse;
        }
   
    }
}
