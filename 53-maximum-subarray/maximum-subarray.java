class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        int startIndex=-1,endIndex=-1;
        int start=0;
        for(int i=0;i<n;i++){
            if(sum==0) start=i;
            sum+=nums[i];
            if(sum>max){
                max=sum;
                startIndex=start;
                endIndex=i;
            }
            if(sum<0){
                sum=0;
            }
            
        }
            System.out.println(startIndex+" "+endIndex);
        return max;
    }
}