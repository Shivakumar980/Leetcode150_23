class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int oddIndex=0;
        int evenindex=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[oddIndex]=nums[i];
                oddIndex++;
                oddIndex++;
            }
            else if(nums[i]<0){
                ans[evenindex]=nums[i];
                evenindex++;
                evenindex++;
            }
        }
        return ans;
        
    }
}