class Solution {

    private int lengthUtil(int ind, int prev, int[][] dp,int[] nums, int n){
        if(ind==n) return 0;
       
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int not_take= lengthUtil(ind+1, prev, dp,nums,n);
        int take=0;
        if( prev==-1 || nums[ind]> nums[prev] ){
            take= 1+lengthUtil(ind+1, ind, dp, nums,n);
        }
        return dp[ind][prev+1]= Math.max(take, not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];

        for(int[] row :dp){
            Arrays.fill(row,-1);
        }
        return lengthUtil(0, -1, dp, nums,n) ;
    }
}