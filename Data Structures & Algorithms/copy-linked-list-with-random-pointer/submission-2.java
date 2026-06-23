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
        if(head==null){Node empty; return head;}
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null,null);
        Node curr = head;
        Node tmpHead = new Node(head.val);
        Node newHead = tmpHead;
        map.put(curr, tmpHead);
        curr= curr.next;
        
        while(curr!=null){
            Node tmp = new Node(curr.val);
            map.put(curr,tmp);
            curr= curr.next;
        }

        curr = head;
        while(curr!=null){
            Node now = map.get(curr);
            Node next = map.get(curr.next);
            Node random = map.get(curr.random);
            now.next=next;
            now.random = random;
            curr= curr.next;
        }
     
        
        return map.get(head);
    }
}
