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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //267 //267 ->762+762 ->1524 -> 4 2 5 1
        // /->1 , % -> 2
        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;
        int quotient =0;
        while(l1!=null || l2!=null || quotient != 0){
            int first = (l1==null)? 0:l1.val;
            int second = (l2==null)? 0:l2.val;
            int last = first+second+quotient;
            quotient = last/10;//1
            int remainder = last%10;//8
            ListNode curr = new ListNode(remainder);
            dummyHead.next = curr;
            dummyHead = dummyHead.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
return result.next;

    }
}
