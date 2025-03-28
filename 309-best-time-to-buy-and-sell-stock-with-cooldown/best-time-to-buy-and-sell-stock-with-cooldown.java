class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+2][2];

        for(int ind=n-1 ; ind>=0 ;ind--){
            for(int buy=0 ; buy<=1 ; buy++){
                int price=0;
                if(buy==1){
                    price = Math.max(-prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                }
                else{
                    price= Math.max(prices[ind]+ dp[ind+2][1], dp[ind+1][0]);
                }
                dp[ind][buy] = price;
            }
        }
        return dp[0][1];
    }
}