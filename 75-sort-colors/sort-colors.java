class Solution {
    public void sortColors(int[] nums) {
        int n= nums.length;
        int low=0;
        int mid=0;
        int high=n-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(low, mid, nums);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(mid,high,nums);
                high--;
            }
        }
    }

    private void swap(int first, int second, int[]nums){
        int temp= nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}