class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        
        int resultLen=0;
        String resultString="";
        for(int i=0;i<n;i++){
            int right=i,left=i;
            while(left>=0 && right<n && s.charAt(right)==s.charAt(left)){
                
                if((right-left+1)>resultLen){
                    resultLen=right-left+1;
                    resultString=s.substring(left,right+1);
                }
                left--;
                right++;
            }
            left=i;
            right=i+1;
             while(left>=0 && right<n && s.charAt(right)==s.charAt(left)){
                
                if((right-left+1)>resultLen){
                    resultLen=right-left+1;
                    resultString=s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return resultString;
    }
}