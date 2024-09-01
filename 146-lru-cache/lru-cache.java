class Node{
    public int key;
    public int val;
    Node next;
    Node prev;

    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
    public Node(){

    }

}
class LRUCache {
    
    HashMap<Integer , Node> hm= new HashMap<>();
    Node dummyhead,dummytail;
    int capacity_;
    public LRUCache(int capacity) {
        capacity_=capacity;
        dummyhead=new Node();
        dummytail=new Node();
        dummyhead.next=dummytail;
        dummytail.prev=dummyhead;
    }
    public void deleteNode(Node node){
        Node nodeleft=node.prev;
        Node noderight=node.next;
        nodeleft.next=noderight;
        noderight.prev=nodeleft;
    }
    public void insertAfterHead(Node node){
        Node rightnode=dummyhead.next;
        dummyhead.next=node;
        node.next=rightnode;
        rightnode.prev=node;
        node.prev=dummyhead;
    
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.val;
        }
            return -1; 
    }
        
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            node.val=value;
            hm.put(key,node);
            deleteNode(node);
            insertAfterHead(node);
        }
        else if(hm.size()==capacity_){
            Node dnode=dummytail.prev;
            deleteNode(dnode);
            hm.remove(dnode.key);
            Node node=new Node(key,value);
            insertAfterHead(node);
            hm.put(key,node);

        }
        else{
             Node node=new Node(key,value);
            insertAfterHead(node);
            hm.put(key,node);
             
        }
        
       
       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */