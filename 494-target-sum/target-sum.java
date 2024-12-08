class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums,target);
    }
     int countPartitions(int[] arr, int d) {
        // code here
        int totalsum=0;
        
        for(int num:arr){
            totalsum+=num;
        }
        if(totalsum-d<0 || (totalsum-d)%2!=0) return 0;
        
        return perfectSum(arr , (totalsum-d)/2);
        
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        if(nums[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
            if(nums[0]<=target){
                dp[0][nums[0]]=1;
            }
        }
        //if(nums[0]!=0 && nums[0]<=target){
          //      dp[0][nums[0]]=1;
          //  }
            
        for(int ind=1;ind<n;ind++){
            for(int sum=0;sum<=target;sum++){
                
                int not_take=dp[ind-1][sum];
                int take=0;
                if(nums[ind]<=sum){
                    take=dp[ind-1][sum-nums[ind]];
                }
                dp[ind][sum]=take+not_take;
            }
        }
        
        return dp[n-1][target];
        
    }
}