class Solution {
    public int search(int[] nums, int target) {
        int n= nums.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid= low+ (high-low)/2;
            if(target==nums[mid]){
                return mid;
            }

            else if(nums[low]<= nums[mid]){
                if(target<nums[low] ||target> nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            else{
                if(target<nums[mid] || target> nums[high]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        return -1;
    }
}