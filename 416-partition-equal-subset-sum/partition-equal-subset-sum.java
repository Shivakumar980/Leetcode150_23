class Solution {


    public boolean canPartition(int[] nums) {
        int target=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            target+=nums[i];
        }
        if(target%2==1) return false;
        target=target/2;
           boolean [][] dp=new boolean [n][target+1]; 

        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target){
             dp[0][nums[0]]=true;
        }
       
        for(int ind=1;ind<n;ind++){
            for(int sum=1;sum<=target;sum++){
                boolean not_take= dp[ind-1][sum];
                boolean take=false;
                if(nums[ind]<=sum){
                    take = dp[ind-1][sum-nums[ind]];
                }
                dp[ind][sum]=take || not_take;
            }
        }

        return dp[n-1][target];
            
    }
}