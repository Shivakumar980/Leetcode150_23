class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> st= new Stack<>();
        for(int i=0; i< n ;i++){
            String str= tokens[i];
            if(str.equals("+")){
                int second= st.pop();
                int first= st.pop();
                st.push(first+second);
            }
            else if(str.equals("-")){
                int second= st.pop();
                int first= st.pop();
                st.push(first-second);
            }
             else if(str.equals("/")){
                int second= st.pop();
                int first= st.pop();
                st.push(first/second);
            }
             else if(str.equals("*")){
                int second= st.pop();
                int first= st.pop();
                st.push(first*second);
            }
            else{
                st.push(Integer.valueOf(str));
            }
        }
        return st.pop();
    }
}