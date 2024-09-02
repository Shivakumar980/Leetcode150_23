  class Node{
        int key;
        int val;
        int frequency;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
            this.frequency=1;
        }
        public Node(){}
    }
    class DoubleLinkedList{
        int listSize;
        Node head;
        Node tail;
        public DoubleLinkedList(){
            this.listSize=0;
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void addNode(Node node){
            Node nextnode=head.next;
            head.next=node;
            node.next=nextnode;
            nextnode.prev=node;
            node.prev=head;
            listSize++;
        }
        public void deleteNode(Node node){
             Node nodeleft=node.prev;
            Node noderight=node.next;
            nodeleft.next=noderight;
            noderight.prev=nodeleft;
            listSize--;
        }

    }
class LFUCache {
     final int capacity;
    int curSize;
    int minFrequency;
    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
         this.capacity=capacity;
         this.curSize=0;
         this.minFrequency=0;
         this.nodeMap=new HashMap<>();
         this.frequencyMap=new HashMap<>();

    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node node=nodeMap.get(key);
            updateNode(node);
            return node.val;
        }
        return -1;
    }
    public void updateNode(Node node){
        int curFreq=node.frequency;
        DoubleLinkedList curList=frequencyMap.get(curFreq);
        curList.deleteNode(node);
        if(curList.listSize==0 && curFreq==minFrequency){
            minFrequency++;
        }
        node.frequency++;
        DoubleLinkedList newList=frequencyMap.getOrDefault(node.frequency,new DoubleLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency,newList);
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(nodeMap.containsKey(key)){
            Node node=nodeMap.get(key);
            node.val=value;
            nodeMap.put(key,node);
            updateNode(node);
        }
        else{
            curSize++;
            if(curSize>capacity){
                DoubleLinkedList freqList=frequencyMap.get(minFrequency);
                nodeMap.remove(freqList.tail.prev.key);
                freqList.deleteNode(freqList.tail.prev);
                curSize--;
            }
            minFrequency=1;
            Node newNode=new Node(key,value);
            DoubleLinkedList curList=frequencyMap.getOrDefault(1,new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            nodeMap.put(key,newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */