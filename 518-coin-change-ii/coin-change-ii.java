class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp= new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return dfs( n-1, amount, coins, dp);
    }

    private int dfs(int ind, int target, int[] coins , int[][] dp){
        if(target==0) return 1;
        if(ind<0) return 0;
        if(ind==0 && target%coins[ind]==0) return 1;
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int not_take= dfs(ind-1, target, coins, dp);
        int take=0;
        if(coins[ind]<=target){
            take= dfs(ind, target-coins[ind], coins, dp);
        }
        return dp[ind][target]= take+not_take;
    }
}