class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int element=nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=element){
                count--;
            }
            else{
                count++;
            }
            if(count==0){
                element=nums[i];
                count=1;
            }
        }
        int cnt=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(element==nums[i]){
                cnt++;
                if(cnt>n/2){
                    ans=element;
                    break;
                }
            }
        }
        return ans;
    }
}