class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int total_sum=0;
        for(int num:nums){
            total_sum+=num;
        }
        if(total_sum-target<0 || (total_sum-target)%2!=0) return 0;
        int target1= (total_sum-target)/2;
        int[][] dp= new int[n][target1+1];
        
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return dfs(n-1, target1, nums, dp);
    }

    private int dfs(int ind, int target, int[] nums, int[][] dp){
        if(ind==0){
            if(target==0 && nums[0]==0) return 2;
            if(target ==0 || target == nums[0]) return 1;
            return 0;
        }

        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }

        int not_take= dfs(ind-1, target, nums, dp);
        int take=0;
        if(nums[ind]<=target){
            take= dfs(ind-1, target-nums[ind], nums, dp);
        }
        return dp[ind][target]= take+not_take;
        }
}