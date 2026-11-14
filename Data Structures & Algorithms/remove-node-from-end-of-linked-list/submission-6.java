class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to head
        // This handles the edge case where we need to remove the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        // We want 'slow' to stop at the node BEFORE the one we want to remove
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches the end
        //there is always n gaps between slow and fast
        //fast = slow + n -> so, when fast.next is null, we have reached the point before removal in slow.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is now right before the target node
        slow.next = slow.next.next;

        // Return the actual head (not dummy)
        return dummy.next;
    }
}