class Solution {
    public int maxSubArray(int[] nums) {
        int max =Integer.MIN_VALUE;
        int n=nums.length;
        int start=-1;
        int end=-1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum==0) start=i;
            sum+=nums[i];
            if(sum>max){
                max=sum;
                end=i;
            }
            
            if(sum<0){
                sum=0;
               // start=i+1;
            }
        }
        System.out.println(start + " " +end);
        return max;
    }
}