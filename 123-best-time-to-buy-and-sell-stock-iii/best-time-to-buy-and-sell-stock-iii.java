class Solution {

  
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];

        for(int buy=0;buy<=1;buy++){
            for(int cap=0;cap<=2;cap++){
                dp[n][buy][cap]=0;
            }
        }
        for(int ind=0;ind<=n;ind++){
            for(int buy=0;buy<=1;buy++){
                dp[ind][buy][0]=0;
            }
        }
        for(int ind=n-1; ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2; cap++){

                    int price=0;
                    if(buy==1){
                        price= Math.max(-prices[ind]+dp[ind+1][0][cap], dp[ind+1][1][cap]);
                    }
                    else{
                        price= Math.max(prices[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                    }

                    dp[ind][buy][cap]=price;

                }
            }
        }
        
        return dp[0][1][2];
    }
}