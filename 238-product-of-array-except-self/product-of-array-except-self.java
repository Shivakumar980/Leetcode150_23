//1,2,6,24
//2.6,12,4
//24,24,12,4
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.fill(res,1);
        int prefix=1;
        for(int i=0;i<nums.length;i++){
            res[i]=prefix;
            prefix=prefix*nums[i];
        }
        int postfix=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[i]*postfix;
            postfix*=nums[i];
        }
        return res;
    }
}