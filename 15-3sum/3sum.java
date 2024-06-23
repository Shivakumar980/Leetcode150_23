class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> alist=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int ans=nums[i]+nums[j]+nums[k];
                if(ans<0){
                    j++;
                }
                else if(ans>0){
                    k--;
                }
                else{
                    List<Integer> res=Arrays.asList(nums[i],nums[j],nums[k]);
                    alist.add(res);
                    j++;
                    k--;
                      while(j<k && nums[j]==nums[j-1]) j++;
                      while(j<k && nums[k]==nums[k+1]) k--;
                } 
                      
            }
        }
        return alist;
        
    }
}