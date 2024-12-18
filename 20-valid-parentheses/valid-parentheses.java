class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st= new Stack<>();

        for(int i=0; i<n;i++){
            if(s.charAt(i)=='('){
                st.push(')');
            }
            else if(s.charAt(i)=='{'){
                st.push('}');
            }
            else if(s.charAt(i)=='['){
                st.push(']');
            }
            else{
                if(!st.isEmpty()){
                    char c= st.pop();
                    if(c!=s.charAt(i)){
                        return false;
                    }
                }
                else{
                    return false;
                }   
            }

        }
        return st.isEmpty();
    }
}