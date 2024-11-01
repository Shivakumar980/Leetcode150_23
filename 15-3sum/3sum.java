class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
            if(sum>0){
                k--;
            }
            else if(sum<0){
                j++;
            }
            else{
                List<Integer> al=Arrays.asList(nums[i],nums[j],nums[k]);
                ans.add(al);
                j++;
                k--;
                //1 2 2 2 2 3 3 3 
                while(j<k && nums[j]==nums[j-1]){
                    j++;
                }
                while(j<k &&nums[k]==nums[k+1]){
                    k--;
                }
            }
            }
            
        }
        
         return ans;
        
    }
}