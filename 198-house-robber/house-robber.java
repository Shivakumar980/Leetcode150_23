class Solution {

   
    public int rob(int[] nums) {
        
        int n= nums.length;
        int[] dp= new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
       
        for(int ind=2 ;ind<=n;ind++){
            int not_take= dp[ind-1];
           
            int take= nums[ind-1]+dp[ind-2];
            dp[ind]=Math.max(take, not_take);
             
        }
        return dp[n];
    }
}