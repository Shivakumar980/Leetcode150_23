class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Character> st= new Stack<>();

        int n= s.length();
        int openBrace=0;
        int closedBrace=0;
        for(int i=0; i<n ;i++){
            
             char c= s.charAt(i);
             if(c=='('){
                openBrace++;

             }
            if(c==')'){
                closedBrace++;
                
             }
            if(closedBrace> openBrace){
                closedBrace--;
                continue;
            }
            else{
                st.push(c);
            }

             
        }

        StringBuilder result= new StringBuilder();

        while(!st.isEmpty()){
            char c1= st.pop();
            if(openBrace> closedBrace && c1=='('){
                openBrace--;
                continue;
            }
            else{
                result.append(c1);
            }
        }
        return result.reverse().toString();
        
    }
}