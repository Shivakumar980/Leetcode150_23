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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        if(length<2) return null;
        temp=dummy;
        int index=length-n;
        while(index>0){
            temp=temp.next;
            index--;
        }
        ListNode temp_node=temp.next.next;
       // temp.next.next=null;
        temp.next=temp_node;
        return dummy.next;
    }
    
}