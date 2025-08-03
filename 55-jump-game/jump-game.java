class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int last_index=n-1;

        for(int i=n-2; i>=0 ;i--){
            if(nums[i]>=last_index-i){
                last_index=i;
            }
        }

        return last_index==0;
    }
}