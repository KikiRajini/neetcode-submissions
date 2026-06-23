/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null){return null;}
        Map<Node,Node> oldToNewMap = new HashMap<>();
        oldToNewMap.put(null, null);
        Node curr = head;
        while(curr !=null){
            Node newCurr = new Node(curr.val);
            oldToNewMap.put(curr, newCurr);
            curr = curr.next;
        }
        Node newHead = oldToNewMap.get(head);
        Node dummy = newHead;
        curr = head;
        while(curr !=null){
            dummy.next = oldToNewMap.get(curr.next);
            dummy.random = oldToNewMap.get(curr.random);
            curr = curr.next;
            dummy = dummy.next;
        }
        return newHead;

    }
}
