class Solution {
    private void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums,int start){
        int end= nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1) {
            reverse(nums,0);}
        else{
            for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                 swap(nums,i,index);
                 break;
            }
        }
        reverse(nums,index+1);
        }
        
       
        
    }
}