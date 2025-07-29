class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<String> st= new Stack<>();
        for(int i=0; i< n ;i++){
            String str= tokens[i];
            if(str.equals("+")){
                int second= Integer.valueOf(st.pop());
                int first= Integer.valueOf(st.pop());
                st.push(String.valueOf(first+second));
            }
            else if(str.equals("-")){
                int second= Integer.valueOf(st.pop());
                int first= Integer.valueOf(st.pop());
                st.push(String.valueOf(first-second));
            }
             else if(str.equals("/")){
                int second= Integer.valueOf(st.pop());
                int first= Integer.valueOf(st.pop());
                st.push(String.valueOf(first/second));
            }
             else if(str.equals("*")){
                int second= Integer.valueOf(st.pop());
                int first= Integer.valueOf(st.pop());
                st.push(String.valueOf(first*second));
            }
            else{
                st.push(str);
            }
        }
        return Integer.valueOf(st.pop());
    }
}