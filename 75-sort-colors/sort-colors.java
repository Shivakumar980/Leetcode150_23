class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zero++;
            if(nums[i]==1) one++;
            if(nums[i]==2) two++;
        }
        int index=0;
        while(zero>0){
            nums[index++]=0;
            zero--;
        }
        while(one>0){
            nums[index++]=1;
            one--;
        }
        while(two>0){
            nums[index++]=2;
            two--;
        }
        
    }
}