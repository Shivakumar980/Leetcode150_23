class Solution {

    private int robUtil(int[] nums,int ind,int[] dp){
        if(ind<0) return 0;
        if(ind==0) return nums[0];

        if(dp[ind]!=-1){
            return dp[ind];
        }
        int not_take= robUtil(nums,ind-1,dp);
        int  take= nums[ind]+ robUtil(nums, ind-2,dp);

        
        return dp[ind]=Math.max(not_take, take);

    }
    public int rob(int[] nums) {
        
        int n= nums.length;

        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return robUtil(nums, n-1,dp);
    }
}