class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
       
        HashSet<List<Integer>> hs=new HashSet<>();
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
                Collections.sort(al);
                hs.add(al);
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
         List<List<Integer>> ans=new ArrayList<>(hs);
         return ans;
        
    }
}