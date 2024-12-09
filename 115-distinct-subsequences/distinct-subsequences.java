class Solution {

    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();

        int[][] dp=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp[i][0]=1;
        }

        for(int ind1=1;ind1<=n1;ind1++){
            for(int ind2=1; ind2<=n2 ;ind2++){
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    dp[ind1][ind2]= dp[ind1-1][ind2-1] +dp[ind1-1][ind2];
                }
                else{
                    dp[ind1][ind2]= dp[ind1-1][ind2];
                }
            }
        }
        
        return  dp[n1][n2];
    }
}