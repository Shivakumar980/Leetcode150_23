class Solution {
    public int findMin(int[] nums) {
        
        int n= nums.length;
        int low= 0;
        int high= n-1;
        int mini= Integer.MAX_VALUE;
        while(low<=high){
            int mid= low+ (high-low)/2;
            //leftsubarray
            if(nums[0]<=nums[mid]){
                mini= Math.min(mini, nums[0]);
                low=mid+1;
            }
            else{
                  mini= Math.min(mini, nums[mid]);
                  high=mid-1;
               

            }

        }
        return mini;
    }
}