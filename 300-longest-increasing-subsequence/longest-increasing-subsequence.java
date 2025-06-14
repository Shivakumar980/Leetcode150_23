class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][] dp= new int[n][n+1];
        for(int[] temp: dp){
            Arrays.fill(temp,-1);
        }
        return dfs(0, -1, nums, dp);
    }
    private int dfs(int ind,int prev_ind, int[] nums, int[][] dp){
        if(ind>=nums.length) return 0;
        if(dp[ind][1+prev_ind]!=-1){
            return dp[ind][1+prev_ind];
        }

        int not_take= dfs(ind+1, prev_ind, nums, dp);
        int take=0;
        if(prev_ind==-1 || nums[ind]> nums[prev_ind]){
            take= 1+ dfs(ind+1, ind, nums, dp);
        }
        return dp[ind][1+prev_ind]=Math.max(take, not_take);
    }
}