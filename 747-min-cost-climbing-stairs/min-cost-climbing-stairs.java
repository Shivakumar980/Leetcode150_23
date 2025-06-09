class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return Math.min(minCost(n-1, cost, dp),minCost(n-2, cost, dp));
    }

    private int minCost(int index, int[] cost, int[] dp){
        if(index<0) return 0;
        if(index==0) return cost[0];
        if (dp[index] != -1) return dp[index];
        int one= cost[index]+minCost(index-1, cost, dp);
        int two=cost[index];
        if(index>1){
            two+=minCost(index-2, cost,dp );
        }
       return dp[index]= Math.min(one,two);
    }
}