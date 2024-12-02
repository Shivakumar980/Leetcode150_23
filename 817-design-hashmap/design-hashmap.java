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
    private static final float LOAD_FACTOR = 0.75f;
    int size=0;
    ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }

    private int hash(int key){
        return key % buckets.length;
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
            size++;
        }
        else{
            prev.next.val=value;
        }
       // if((float)size/buckets.length >LOAD_FACTOR){
       //     resize();
       // }
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
            size--;
        }
        
    }
    private void resize() {
        ListNode[] oldBuckets = buckets;
        buckets = new ListNode[oldBuckets.length * 2];
        size = 0; // Reset size and re-add elements

        for (ListNode head : oldBuckets) {
            if (head != null) {
                ListNode node = head.next; // Skip the dummy head
                while (node != null) {
                    put(node.key, node.val); // Rehash and insert into the new buckets
                    node = node.next;
                }
            }
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