class Solution {
    public int climbStairs(int n) {

        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);

        return climb(dp, n);
    }

    private int climb(int[] dp, int n){
        if(n==0 || n==1) return 1;
        if(dp[n]!=-1){
            return dp[n];
        }
        int one= climb(dp,n-1);
        int two=0;
        if(n>1){
            two=climb(dp,n-2);
        }
        return dp[n]=one +two;
    }
}