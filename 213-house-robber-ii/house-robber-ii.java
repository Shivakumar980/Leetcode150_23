class Solution {

    private int accomplice(int[] nums,int index,int[] dp){
        if(index< 0) return 0;

        if(dp[index]!=-1){
            return dp[index];
        }

        int one= nums[index]+ accomplice(nums,index-2, dp);
        int two= accomplice(nums,index-1,dp);

        return dp[index]=Math.max(one ,two);

    }


    public int rob(int[] nums) {

        int n=nums.length;
        //edge case important
        if(n==1) return nums[0];

        int[] subarray1=Arrays.copyOfRange(nums,1,n);
        int[] dp1=new int[subarray1.length];
        Arrays.fill(dp1,-1);

        int[] subarray2=Arrays.copyOfRange(nums,0,n-1);
        int[] dp2=new int[subarray2.length];
        Arrays.fill(dp2,-1);

       
       

        return Math.max(accomplice(subarray1,subarray1.length-1,dp1),accomplice(subarray2,subarray2.length-1,dp2));  
    }
}