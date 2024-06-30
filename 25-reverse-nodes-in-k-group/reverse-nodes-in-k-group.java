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
    private ListNode findKthNode(ListNode head,int k){
        while(k>1 && head!=null){
            k--;
            head=head.next;
        }
        return head;
    }
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevLast=null;
        while(temp!=null){
        ListNode kthNode=findKthNode(temp,k);
        if(kthNode==null){
            if(prevLast!=null){
                prevLast.next=temp;
            }
            break;
        }
        ListNode nextNode=kthNode.next;
        kthNode.next=null;
        reverseLinkedList(temp);
        if(temp==head){
            head=kthNode;
        }
        else{
            prevLast.next=kthNode;
        }
        prevLast=temp;
        temp=nextNode;
        }
        return head;
    }
}