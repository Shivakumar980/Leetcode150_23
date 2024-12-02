class ListNode{
    int key;
    int val;
    ListNode next;

    public ListNode(int key, int val, ListNode next){
        this.key=key;
        this.val=val;
        this.next=next;
    }
}
class MyHashMap {

    private static final int SIZE=1000;
    ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }

    private int hash(int key){
        return key % SIZE;
    }
    
    private ListNode findPrevNode(ListNode head, int key){
        ListNode node= head;
        while(node.next!=null && node.next.key!=key){
            node=node.next;
        }
        return node;
    }
    public void put(int key, int value) {
        int index = hash(key);
        if(buckets[index]==null){
            buckets[index]=new ListNode(-1,-1,null);
        }
        ListNode  prev=findPrevNode(buckets[index],key);
        if(prev.next==null){
            prev.next=new ListNode(key,value,null);
        }
        else{
            prev.next.val=value;
        }
    }
    
    public int get(int key) {
        int index =hash(key);

        if(buckets[index]==null){
            return -1;
        }
        ListNode prev= findPrevNode(buckets[index],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.val; 
    }
    
    public void remove(int key) {
        int index=hash(key);
        if(buckets[index]==null){
            return;
        }
        ListNode prev= findPrevNode(buckets[index],key);
        if(prev.next!=null){
            prev.next=prev.next.next;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */