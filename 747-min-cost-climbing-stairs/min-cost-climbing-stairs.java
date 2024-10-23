class Solution {
    private int minCost(int[] cost, int index,int[] dp){
        if(index==1 || index==0) return cost[index];
        if(dp[index]!=-1){
            return dp[index];
        }
        int twostep=cost[index]+minCost(cost,index-2,dp);
        int onestep=cost[index]+minCost(cost,index-1,dp);
        return dp[index]=Math.min(onestep,twostep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
    }
}