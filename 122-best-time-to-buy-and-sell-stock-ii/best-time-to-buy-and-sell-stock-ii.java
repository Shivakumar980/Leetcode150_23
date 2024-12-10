class Solution {

    private int maxProfitUtil(int ind, int buy, int[] prices,int[][] dp,int n){
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==1){
             profit= Math.max(-prices[ind] + maxProfitUtil(ind+1, 0, prices ,dp, n), 
                                                maxProfitUtil(ind+1,1,prices,dp, n));
        }
        else{
             profit=Math.max( prices[ind]+maxProfitUtil(ind+1, 1, prices, dp, n) ,
            maxProfitUtil(ind+1,0,prices,dp, n) );
        }
        return dp[ind][buy]= profit;

    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return maxProfitUtil(0,1,prices,dp,n);
    }
}