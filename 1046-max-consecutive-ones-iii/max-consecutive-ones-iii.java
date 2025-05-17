class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=0;
        int maxlength=0;
        int zeroes=0;
        while(right<n){
           
            if(nums[right]==0){
                zeroes++;
            }
            while(zeroes>k && left< right){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            if(zeroes<=k){
                maxlength= Math.max(maxlength, right-left+1);
            }
            right++;
        }
        return maxlength;
    }
}