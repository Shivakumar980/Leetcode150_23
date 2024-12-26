class Solution {

    private int maxProfitUtil(int ind, int buy, int cap, int[] prices, int[][][] dp){
        if( cap==0 || ind==prices.length ) return 0;
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[ind]+maxProfitUtil(ind+1,0,cap,prices,dp), maxProfitUtil(ind+1,1,cap,prices,dp));
        }
        else{
            profit=Math.max(prices[ind]+maxProfitUtil(ind+1,1,cap-1,prices,dp),maxProfitUtil(ind+1,0,cap,prices,dp));
        }
       return dp[ind][buy][cap]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int[][] row1: dp){
            for(int[] row2:row1){
                Arrays.fill(row2,-1);
            }
        }

        return maxProfitUtil(0,1,2,prices,dp);
    }
}