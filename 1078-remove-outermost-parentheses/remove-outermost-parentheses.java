class Solution {
    public String removeOuterParentheses(String s) {
        
        int n=s.length();
        StringBuilder sb=new StringBuilder();

        int countOpen=0;
        for(int i=0;i<n;i++){
           
            if(s.charAt(i)=='('){
                 if(countOpen>0){
                    sb.append(s.charAt(i));
                    }
                countOpen++;
            }
            else if(s.charAt(i)==')'){
                countOpen--;
                if(countOpen>0){
                    sb.append(s.charAt(i));
                }

            }

        }
        return sb.toString();
    }
}