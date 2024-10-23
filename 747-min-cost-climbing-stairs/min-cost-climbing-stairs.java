class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
                 int twostep=dp[i-2];
                 int onestep=dp[i-1];
            dp[i]=cost[i]+Math.min(twostep,onestep);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}