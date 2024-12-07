class Solution {

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int amt=0; amt <= amount ;amt++){
              dp[0][amt]= amt % coins[0]==0 ? amt/coins[0] : (int) 1e9 ;
        }
      
       for(int ind=1; ind<n;ind++){
            for(int target=0;target<=amount;target++){

                int not_take= 0 + dp[ind-1][target];
                int take= (int)1e9;
                if(coins[ind]<=target){
                    take= 1+ dp[ind][target-coins[ind]];
                }
                dp[ind][target]=Math.min(take, not_take);
            }
       }

       return dp[n-1][amount]==(int)1e9 ? -1 : dp[n-1][amount];
        
    }
}