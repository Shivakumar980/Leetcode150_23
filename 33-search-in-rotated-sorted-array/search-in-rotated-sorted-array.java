class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0 , right= n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[left]<=nums[mid]){
                if(target > nums[mid] || target < nums[left]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            else{
                if(target<nums[mid] || target> nums[right]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return -1;
        
    }
}