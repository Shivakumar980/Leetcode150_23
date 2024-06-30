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
    public boolean isPalindrome(ListNode head) {

      Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {

            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
    
        // Compare values by popping from the stack
        // and checking against linked list nodes
        while (temp != null) {
            if (temp.val != st.peek()) {
                // If values don't match,
                // it's not a palindrome
                return false;
            }
    
            // Pop the value from the stack
            st.pop();
    
      
            temp = temp.next;
        }

        return true;
    }
    }
