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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listHead1 = list1;
        ListNode listHead2 = list2;
        ListNode r = new ListNode();
        ListNode result= r;
        while(listHead1 !=null || listHead2 !=null){
            if(listHead1 !=null && listHead2 !=null){
                if(listHead1.val<=listHead2.val){
                    result.next = listHead1;
                    result = result.next;
                    listHead1 = listHead1.next;
                }else {
                    result.next = listHead2;
                    result = result.next;
                    listHead2 = listHead2.next;
                }
            }else if(listHead1 ==null && listHead2 !=null){
                    result.next = listHead2;
                    result = result.next;
                    listHead2 = listHead2.next;
            }else if(listHead1 !=null && listHead2 ==null){
                    result.next = listHead1;
                    result = result.next;
                    listHead1 = listHead1.next;
            }
        }
        return r.next;
    }
}