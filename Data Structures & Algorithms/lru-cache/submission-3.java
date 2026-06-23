class Node{
    int val;
    int key;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key; this.val = val; 
        this.prev=null; this.next=null;
    }
}

class LRUCache {
    
    Map<Integer,Node> cache;
    int capacity =0;
    int currCap = 0;
    Node left; Node right;
    //left -> right
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right =  new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        int val = -1;
        if(cache.containsKey(key)){
            val = cache.get(key).val;
            remove(cache.get(key));
            insert(key,val);
        }
        return val;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){  
            remove(cache.get(key));            
        }
        if(currCap>=capacity){
            remove (this.left.next);
        } 
        insert(key,value);
    }

    public void insert (int key, int value){
            Node newNode = new Node(key,value);
            cache.put(key, newNode);
            currCap++;
            Node prev = this.right.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = this.right;
            this.right.prev = newNode;
    }

    public void remove (Node node){
            Node toTheLeft = node.prev;
            Node toTheRight = node.next;
            toTheLeft.next = toTheRight;
            toTheRight.prev = toTheLeft;
            cache.remove(node.key);
            currCap--;
    }


}