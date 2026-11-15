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
    public ListNode mergeKLists(ListNode[] lists) {
    
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode list : lists){
            if(list!=null){
            pq.offer(list);
            }
        }

        ListNode result = new ListNode(0);
        ListNode start = result;
        while(!pq.isEmpty()){
            ListNode insert = pq.poll();
            start.next = insert;//temporarily attaches the whole list but gets re-written on the next loop. on the final loop node->null gets attached as expected.
            if(insert.next !=null){
            pq.offer(insert.next);}
            start = start.next;
        }

        return result.next;
    }
}
