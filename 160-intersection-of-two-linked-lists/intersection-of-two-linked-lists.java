/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA=0,countB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null){
            countA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            countB++;
            tempB=tempB.next;
        }
        int diff=countA-countB;
            if(diff<0){
                while(diff!=0){
                    headB=headB.next;
                    diff++;
                }
            }
            else{
                while(diff!=0){
                    headA=headA.next;
                    diff--;
                }
            }
        while(headA!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }

        return null; 
    }
}