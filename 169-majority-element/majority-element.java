class Solution {
    public int majorityElement(int[] nums) {
        int cnt =0;
        int element=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(cnt==0){
                element=nums[i];
                cnt++;
            }
            else if(element==nums[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        cnt=0;
       for(int i=0;i<n;i++){
        if(nums[i]==element){
            cnt++;
            if(cnt>n/2){
                return element;
            }
        }
       }
         return -1;
    }
}