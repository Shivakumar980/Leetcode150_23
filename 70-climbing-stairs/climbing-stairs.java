class Solution {

    private int climbStairsUtil(int[] dp,int n){
        if(n==1 || n==0) return 1;

        if(dp[n]!=-1){
            return dp[n];
        }
        int oneStep=climbStairsUtil(dp,n-1);
        int twoStep=0;
        if(n>1){
             twoStep=climbStairsUtil(dp,n-2);
        }

        return dp[n]=oneStep+twoStep;

    }
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairsUtil(dp,n);
        
    }
}