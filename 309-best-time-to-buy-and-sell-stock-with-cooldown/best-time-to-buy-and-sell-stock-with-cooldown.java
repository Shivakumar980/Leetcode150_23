class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return dfs(0, 1, prices, dp);

    }
    private int dfs(int ind, int buy, int[] prices , int[][] dp){
        if(ind>=prices.length){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            dp[ind][buy]= Math.max(-prices[ind]+ dfs(ind+1, 0, prices, dp), dfs(ind+1,1, prices, dp));
        }
        else{
            dp[ind][buy]=Math.max(prices[ind]+ dfs(ind+2,1,prices,dp), dfs(ind+1, 0, prices,dp));
        }
        return dp[ind][buy];
    }

}