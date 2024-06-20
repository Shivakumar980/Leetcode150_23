class Solution {
    public int findDuplicate(int[] nums) {
        int len=nums.length;
        int ans=0;
        int[] freq=new int[len];
        for(int i=0;i<len;i++){
            
            if(freq[nums[i]]==0){
                freq[nums[i]]++;
            }
            else{
                return  ans= nums[i];
            }
        }
       
        return ans;
    }
}