class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];

        int[] sub_arr1=Arrays.copyOfRange(nums, 1, n);

        int[] sub_arr2=Arrays.copyOfRange(nums, 0, n-1);

        int[] dp1= new int[n-1];
        int[] dp2= new int[n-1];
        
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        return Math.max(dfs(sub_arr1, dp1,n-2), dfs(sub_arr2, dp2, n-2));
    }

    private int dfs(int[] nums, int[] dp, int index ){
        if(index<0) return 0;
        if(index==0) return nums[0];
        if(dp[index]!=-1){
            return dp[index];
        }
        int take=  nums[index] + dfs(nums, dp, index-2);
        int not_take= dfs(nums, dp, index-1);

        return dp[index]= Math.max(take, not_take);
    }
}