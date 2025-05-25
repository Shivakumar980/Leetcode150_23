class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key= key;
        this.val=val;
    }

    public Node(){

    }


}

class LRUCache {

    int _capacity;
    HashMap<Integer, Node> cache= new HashMap<>();
    Node dummyhead;
    Node dummytail;

    public LRUCache(int capacity) {
        this._capacity= capacity;
         dummyhead=new Node();
         dummytail=new Node();
        dummyhead.next= dummytail;
        dummytail.prev= dummyhead;

    }
    
    public int get(int key) {
        //case 1: it contains key -> delete- > insert afterhead
        //case 2: does not contains
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node=cache.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)){
            Node node= cache.get(key);
            node.val= value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            if(cache.size()==_capacity){
                Node node = dummytail.prev;
                deleteNode(node);
                cache.remove(node.key);
            }
            Node node= new Node(key,value);
            insertAfterHead(node);
            cache.put(key, node);
        }
        
    }

    public void deleteNode(Node node){
        Node nextNode= node.next;
        Node prevNode= node.prev;

        nextNode.prev= prevNode;
        prevNode.next= nextNode;
    }

    public void insertAfterHead(Node node){
        Node nextNode= dummyhead.next;
        dummyhead.next= node;
        node.next= nextNode;
        nextNode.prev= node;
        node.prev= dummyhead;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */