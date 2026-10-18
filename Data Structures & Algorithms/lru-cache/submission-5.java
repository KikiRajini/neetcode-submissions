class Node {
    int val;
    int key;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key; 
        this.val = val; 
        this.prev = null; 
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node left;  // LRU dummy node
    Node right; // MRU dummy node

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        
        // left -> right
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    // Helper to remove a node from the linked list
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    // Helper to insert a node at the right (MRU position)
    private void insert(Node node) {
        Node prevNode = right.prev;
        
        prevNode.next = node;
        node.prev = prevNode;
        
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Move to most recently used
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // If key exists, remove the old node first
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        
        // If capacity exceeded, evict the LRU node (left.next)
        if (cache.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key); // Important: remove from map too
        }
    }
}