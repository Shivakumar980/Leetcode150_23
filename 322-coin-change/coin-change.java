class Solution {

    private int coinChangeUtil(int ind, int target, int[][] dp, int[] coins)
    {
        if(ind==0){
            return target % coins[ind] == 0 ? target/coins[ind] : (int)1e9 ; 
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int not_take= 0 + coinChangeUtil(ind-1, target, dp, coins);
        int take= (int)1e9;
        if(coins[ind]<=target){
            take= 1 + coinChangeUtil(ind, target-coins[ind], dp, coins);
        }
         dp[ind][target]= Math.min(take,not_take);
         return dp[ind][target];
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int result= coinChangeUtil(n-1, amount, dp, coins);

        if(result>=(int)1e9){
            return -1;
        }
        return result;
        
    }
}