class Solution {
     private int maxProfitUtil(int ind, int buy, int cap, int[] prices, int[][][]dp , int n){

        if(cap==0 || ind==n ) return 0;
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int price=0;
        if(buy==1){
            price = Math.max(-prices[ind]+maxProfitUtil(ind+1, 0, cap, prices, dp , n),
            maxProfitUtil(ind+1,1,cap,prices,dp,n));
        }
        else{
            price=Math.max(prices[ind]+maxProfitUtil(ind+1,1,cap-1,prices,dp,n),
                maxProfitUtil(ind+1,0,cap,prices,dp,n));
        }
        return dp[ind][buy][cap]=price;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][k+1];
        for(int[][] twoDrow:dp){
            for(int[] row:twoDrow){
                Arrays.fill(row,-1);
            }
        }

        return maxProfitUtil(0,1,k,prices,dp,n);
        
    }
}