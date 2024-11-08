class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int resLen=0;
        String res="";
        for(int i=0;i<n;i++){
            int left=i;
            int right=i;

            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1>resLen){
                    resLen=right-left+1;
                    res=s.substring(left,right+1);
                }
                left--;
                right++;
            }
             left=i;
             right=i+1;
            while(left>=0 && right <n && s.charAt(left)==s.charAt(right)){
                if(right-left+1> resLen){
                    resLen=right-left+1;
                    res=s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return res;
        
    }
}