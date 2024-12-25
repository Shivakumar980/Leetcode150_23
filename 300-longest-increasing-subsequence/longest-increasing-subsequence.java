class Solution {

    private int lisUtil(int ind,int prev,int n, int[] nums,int[][] dp){
       if(ind==n) return 0;
       
       if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
       }
       int not_take=lisUtil(ind+1, prev, n, nums,dp);
       int take=0;
       if(prev==-1 || nums[ind]>nums[prev]){
            take= 1+ lisUtil(ind+1, ind, n, nums, dp);
       }

       return dp[ind][prev+1]= Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lisUtil(0,-1, n, nums, dp);
    }
}