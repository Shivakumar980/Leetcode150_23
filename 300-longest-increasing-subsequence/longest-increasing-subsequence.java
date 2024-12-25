class Solution {

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
          int lis=1;
        for(int ind=0;ind<n;ind++){
            for(int prev=0; prev<ind;prev++){
                if(nums[ind]>nums[prev] && 1+dp[prev]>dp[ind]){
                    dp[ind]=1+dp[prev];
                }

            }
            lis= Math.max(lis, dp[ind]);

        }
    return lis;
      
    }
        
       
    }
