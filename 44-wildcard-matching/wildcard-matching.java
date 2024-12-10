class Solution {

    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();

        boolean[][] dp=new boolean[n1+1][n2+1];
        dp[0][0]=true;
        boolean flag=true;
        for(int ind2=1;ind2<=n2;ind2++){
            if(p.charAt(ind2-1)!='*'){
                flag= false;
            }
            dp[0][ind2]=flag;
    
        }
        for(int ind1=1;ind1<=n1;ind1++){
            dp[ind1][0]=false;
        }

        for(int ind1=1;ind1<=n1;ind1++){
            for(int ind2=1;ind2<=n2;ind2++){

                if(s.charAt(ind1-1)==p.charAt(ind2-1) || p.charAt(ind2-1)=='?'){
                    dp[ind1][ind2]=dp[ind1-1][ind2-1];
                }
                else if(p.charAt(ind2-1)=='*'){
                    dp[ind1][ind2]=dp[ind1-1][ind2] || dp[ind1][ind2-1];
                }
                else{
                    dp[ind1][ind2]=false;
                }
            }
           
        }
         return dp[n1][n2];

        
        
    }
}