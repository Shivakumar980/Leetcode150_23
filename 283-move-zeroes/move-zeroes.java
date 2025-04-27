class Solution {
    public void moveZeroes(int[] nums) {
        
        int n= nums.length;

        int zeroindex=0;

        for(int i=0; i<n ;i++){
            if(nums[i]!=0){
                int temp= nums[zeroindex];
                nums[zeroindex]=nums[i];
                nums[i]=temp;
                zeroindex++;
            }   
        }
    }
}