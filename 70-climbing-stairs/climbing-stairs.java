class Solution {

    private int climbStairsUtil(int ind, int[] dp){
        if(ind==0 || ind ==1) return 1;


        if(dp[ind]!=-1){
            return dp[ind];
        }

        int onestep= climbStairsUtil(ind-1,dp);
        int twostep=0;
        if(ind>1){
            twostep= climbStairsUtil(ind-2,dp);
        }
        return dp[ind]=onestep +twostep;
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairsUtil(n , dp);
    }
}