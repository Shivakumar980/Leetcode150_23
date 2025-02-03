class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count=1;
        int n= nums.length;
        int incount=1;
        int decount=1;
        for(int i=0; i<n-1;i++){
            if(nums[i]<nums[i+1]){
                incount++;
                decount=1;
                count= Math.max(count,incount);
            }
            else if(nums[i]>nums[i+1]){
                decount++;
                incount=1;
                count= Math.max(count,decount);
            }
            else{
                decount=1;
                incount=1;
             }
            
        }
        return count;
    }
}

//1342234654