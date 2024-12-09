class Solution {

    private int numDistinctUtil(int ind1, int ind2, String s, String t, int[][] dp){

        
        if(ind2<0){
            return 1;
        }
        if(ind1<0){
            return 0;
        }

        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }

        if(s.charAt(ind1)==t.charAt(ind2)){
            return dp[ind1][ind2]= numDistinctUtil(ind1-1,ind2-1,s, t, dp) +numDistinctUtil(ind1-1,ind2,s,t,dp);
        }
        else{
            return dp[ind1][ind2]=numDistinctUtil(ind1-1,ind2,s,t,dp);
        }

    }
    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();

        int[][] dp=new int[n1][n2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return  numDistinctUtil(n1-1, n2-1, s, t, dp);
    }
}