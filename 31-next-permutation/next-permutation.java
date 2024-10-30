class Solution {
    public void reverse(int[] arr,int start,int end){    
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;
        int n=nums.length;
        //step 1: find the index smaller than right
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(nums,0,n-1);
            return;
        }
        // find the next greater
        //swap
        for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        //reverse
        reverse(nums,index+1,n-1);

    }
}