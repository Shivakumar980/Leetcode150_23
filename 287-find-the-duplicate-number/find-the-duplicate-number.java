class Solution {
    public int findDuplicate(int[] nums) {
        int len=nums.length;
        int ans=0;
        int[] res=new int[len];
        for(int i=0;i<len;i++){
            res[nums[i]]++;
            if(res[nums[i]]>1){
                 ans= nums[i];
                break;
            }
        }
       
        return ans;
    }
}