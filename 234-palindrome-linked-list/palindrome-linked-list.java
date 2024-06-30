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
    private ListNode reverseLinkedList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;  
        }
        return prev;

    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.val);
        ListNode newHead=reverseLinkedList(slow);
        ListNode start=head;
        ListNode end=newHead;
        while(start!=slow){
            System.out.println(end.val);
            if(start.val!=end.val){
                return false;
            }
            start=start.next;
            end=end.next;
        }
        return true;
    }
    }
