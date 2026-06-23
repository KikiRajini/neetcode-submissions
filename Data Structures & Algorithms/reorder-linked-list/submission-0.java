class Solution {
    public void reorderList(ListNode head) {
        //center of the listnode
        //split into two listnode + reverse the second one
        //combine them

        ListNode slow= head; 
        ListNode fast = head;

        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
//[0, 1, 2, 3, 4, 5, 6]
//slow -> 3, fast ->6
//mid->4
//4,5,6->null -> 6,5,4->null
        ListNode curr = slow.next;//4
      
        ListNode prev = null;
        slow.next=null;
        while(curr!=null){
            ListNode next = curr.next;//5
            curr.next= prev;
            prev=curr;
            curr=next;
        }

ListNode first = head;
ListNode second = prev;

while (second != null) {
    ListNode tmp1 = first.next;
    ListNode tmp2 = second.next;

    first.next = second;
    second.next = tmp1;

    first = tmp1;
    second = tmp2;
}


    }
}
