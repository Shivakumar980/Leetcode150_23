class Solution {
    public String removeKdigits(String s, int k) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while (k > 0) {
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length()==0 ? "0" : sb.toString();
    }
}