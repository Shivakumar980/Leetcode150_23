class Solution {
    public String removeKdigits(String num, int k) {
        int n= num.length();
        Stack<Character> st= new Stack<>();

        for(int i=0; i< n; i++){
            char c= num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()> c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        //edge case , more numbers added 123456, , remove last 3
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb= new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        // edge case to remove zeroes at the beginning
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.length()==0 ? "0": sb.toString();

    }
}