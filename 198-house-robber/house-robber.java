class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return accomplice(dp,nums, n-1);
    }

    private int accomplice(int[] dp,int[] nums, int index){
        if(index<0) return 0;
        if(index==0){
            return nums[0];
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int take= nums[index]+ accomplice(dp, nums, index-2);
        int not_take= accomplice(dp, nums, index-1);

        return dp[index]= Math.max(take, not_take);
    }
}