/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Pair{
    int value;
    ListNode node;
    
    public Pair(int value, ListNode node){
        this.value= value;
        this.node= node;
       
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int n= lists.length;

        ListNode dummy =new ListNode(0);
        ListNode head= dummy;
        

        PriorityQueue< Pair> pq= new PriorityQueue<>((a,b)-> a.value - b.value);

        for(int i=0;i<n;i++){
            ListNode node= lists[i];
            if(node!=null) pq.add(new Pair( node.val, node));
            
        }
        // 1,0,[1]
        //1,1,[1]
        //2,2,[2]
        while(!pq.isEmpty()){
                Pair smallest= pq.poll();
                head.next =smallest.node;
                head= head.next;

                if(smallest.node.next!=null){
                    pq.add(new Pair(smallest.node.next.val,  smallest.node.next));
                }

        }

        return dummy.next; 
    }
}