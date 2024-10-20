class Solution {
    private int CountOfArrays(int[] nums,int mid,int n){
        int count=1;
        int lastsum=0;
        for(int i=0;i<n;i++){
            if(lastsum+nums[i]<=mid){
                lastsum+=nums[i];
            }
            else{
                lastsum=nums[i];
                count++;
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        int n=nums.length;
        if(n<k) return -1;
        for(int i=0;i<nums.length;i++){
            low=Math.max(nums[i],low);
            high+=nums[i];   
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int numOfsubs=CountOfArrays(nums,mid,n);
            if(numOfsubs<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

}