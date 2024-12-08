class Solution {

    private int changeWays(int ind, int target, int[][] dp, int[] coins){
      
        if(ind==0){
            if(target%coins[0]==0) return 1;
            else return 0;
        }

        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int not_take= 0 + changeWays(ind-1,target,dp,coins);
        int take=0;
        if(coins[ind]<=target){
            take= changeWays(ind, target-coins[ind], dp, coins);
        }
        return dp[ind][target]=take + not_take;

    }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return changeWays(n-1, amount, dp, coins);
    }
}