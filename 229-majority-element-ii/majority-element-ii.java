class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                   
                }
            }
             if(count>n/3){
                        if(ans.size()!=0 && ans.size()<=2 && ans.get(0)==nums[i]){
                            continue;
                        }
                        if(ans.size()<2){
                             ans.add(nums[i]);
                        }
                       
                        
                    }
           

        }
         return ans;
    }   
}