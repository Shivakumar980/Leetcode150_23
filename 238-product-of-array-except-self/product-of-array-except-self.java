class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix= new int[n];
        int[] suffix= new int[n];
        int[] ans= new int[n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]*prefix[i-1];
            int j=n-i-1;
            suffix[j]=nums[j]*suffix[j+1];
        }

        ans[0]=suffix[1];
        ans[n-1]=prefix[n-2];
        for(int i=1;i<n-1;i++){
            ans[i]= prefix[i-1]*suffix[i+1];
        }
        return ans;
    }
}