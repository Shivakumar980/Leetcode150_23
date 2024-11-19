class Solution {

    private int accomplice(int[] nums, int[] dp ,int index){


        if(index<0) return 0;
        if(index==0) return nums[0];

        if(dp[index]!=-1){
            return dp[index];
        }

      
            int take= nums[index] + accomplice(nums,dp,index-2);

            int not_take=  accomplice(nums, dp,index-1);

        return dp[index]=Math.max(take,not_take);
    }

    public int rob(int[] nums) {

        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        return accomplice(nums, dp, n-1);
    
    }
}