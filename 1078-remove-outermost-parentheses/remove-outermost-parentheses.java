class Solution {
    public String removeOuterParentheses(String s) {
        
        int n=s.length();
        int openCount=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){

            char c=s.charAt(i);
            if(c=='('){
               
                if(openCount>0){
                    sb.append(c);
                }
                 openCount++;
            }
            else{
                openCount--;
                if(openCount>0){
                    sb.append(c);
                }
                
            }
            

        }
       
        return sb.toString();
    }
}