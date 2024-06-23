class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> output = new HashSet<>();
        int n=nums.length;
        //int remaining_sum=0;
        for(int i=0;i<n;i++){
        	//to lookup the remaining sum by fixating i
            for(int j=i+1;j<n;j++){
                  HashSet<Long> hs=new HashSet<>();
                  for(int k=j+1;k<n;k++){
                        long fourth=target-((long)nums[i]+(long)nums[j]+(long)nums[k]);
                if(hs.contains(fourth)){
                    List<Integer> al=Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                    al.sort(null);
                    output.add(al);
                }
                hs.add((long)nums[k]);
                  }
                
            }
        }
        List<List<Integer>> ans = new ArrayList<>(output);
        return ans;
    }

    
}