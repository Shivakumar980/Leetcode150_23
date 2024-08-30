class Solution {
    public static boolean isValid(String s) {
        boolean flag=false;
        Stack<Character> st=new Stack<Character>();
       for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c=='('){
            st.push(')');
        }
        else if(c=='{'){
            st.push('}');
        }
        else if(c=='['){
            st.push(']');
        }
        else if( st.isEmpty() || st.pop()!=c){
                 return false;
            }
        }
        return st.isEmpty();
       }
       
    }
