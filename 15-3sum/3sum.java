class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> output = new HashSet<>();
       
        int n=nums.length;
        int remaining_sum=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i+1;j<n;j++){
                remaining_sum=-(nums[i]+nums[j]);
                if(hs.contains(remaining_sum)){
                    List<Integer> al=Arrays.asList(nums[i],nums[j],remaining_sum);
                    al.sort(null);
                    output.add(al);
                }
                hs.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(output);
        return ans;
    }
}