class Solution {


    private boolean partitionUtil(int[][] dp, int[] nums, int ind, int target){

        if(target==0) return true;
        if(ind==0){
            return nums[ind]==target;
        }

        if(dp[ind][target]!=-1){
            return dp[ind][target]==0 ? true:false;
        }

        boolean not_take= partitionUtil(dp,nums,ind-1,target);

        boolean take= false;
        if(target>=nums[ind]){
            take = partitionUtil(dp, nums, ind-1, target-nums[ind]);
        }
        dp[ind][target]= take || not_take? 0:1;

        return take|| not_take;

    }
    public boolean canPartition(int[] nums) {
        int target=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            target+=nums[i];
        }
        if(target%2==1) return false;

        int[][] dp=new int[n][target+1]; 
        for(int[] row:dp){
            Arrays.fill(row,-1);
        } 

        return partitionUtil(dp, nums, n-1, target/2);      
    }
}