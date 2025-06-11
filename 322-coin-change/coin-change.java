class Solution {
    public int coinChange(int[] coins, int amount) {

            int n= coins.length;
            int[][] dp= new int[n][amount+1];
            for(int[] oneD: dp){
                 Arrays.fill(oneD,-1);
            }
            int result= dfs(coins, n-1, amount, dp);

            return result==(int)1e9 ? -1: result;
    }

    private int dfs(int[] coins, int ind, int target, int[][] dp){
        if(ind==0){
            if(target%coins[0]==0){
                return target/coins[0];
            }
            else{
                return (int)1e9;
            }
            }
            if(dp[ind][target]!=-1){
                return dp[ind][target];
            }

            int not_take=dfs(coins,ind-1, target,dp);
            int take=  (int)1e9;
            if(coins[ind]<=target){
                take= 1+ dfs(coins, ind, target-coins[ind], dp);
            }
            return dp[ind][target]=Math.min(take,not_take);
        
    }
}