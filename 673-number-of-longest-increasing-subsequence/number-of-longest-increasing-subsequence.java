class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] count=new int[n];
        Arrays.fill(count,1);

        int maxval=1;
        for(int ind=1 ;ind<n ;ind++){
            for(int prev=0; prev<ind ;prev++){
                if(nums[prev]<nums[ind] && 1+dp[prev]>dp[ind]){
                    dp[ind]= 1+dp[prev];
                    count[ind]=count[prev];
                }
                else if(nums[prev]<nums[ind] && 1+dp[prev]==dp[ind]){
                    count[ind]+=count[prev];
                   
                }
            }
             maxval=Math.max(maxval, dp[ind]);
        }
        int sum=0;
       for(int ind=0;ind<n;ind++){
            if(dp[ind]==maxval){
                sum+=count[ind];
            }
       }
       return sum;
    }
}