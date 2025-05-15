class Solution {
    public boolean isValid(String s) {
        int n= s.length();
        Stack<Character> st= new Stack<>();

        for(int i=0; i< n ;i++){
            int c= s.charAt(i);
            if(s.charAt(i)=='('){
                st.push(')');
            }
            else if(s.charAt(i)=='{'){
                st.push('}');
            }
            else if(s.charAt(i)=='['){
                st.push(']');
            }
            else if(st.isEmpty() || st.pop()!=c){
                return false;
            }
            
        }
        return st.isEmpty();
    }
}