class Solution {

    public int minCostHelper(int[] cost,int ind,int[] dp){
        if(ind==0 || ind==1){
            return cost[ind];
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
       
        int one=cost[ind]+minCostHelper(cost,ind-1,dp);
        int two=Integer.MAX_VALUE;
        if(ind>1){
             two=cost[ind]+minCostHelper(cost,ind-2,dp);
        }
       
        return dp[ind]=Math.min(one,two);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCostHelper(cost,n-1,dp),minCostHelper(cost,n-2,dp));
    }
}