class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        HashSet<List<Integer>> output=new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int remainingSum=-(nums[i]+nums[j]);
                if(hs.contains(remainingSum)){
                    List<Integer> al=Arrays.asList(nums[i],nums[j],remainingSum);
                    al.sort(null);
                    output.add(al);
                }
                else{
                    hs.add(nums[j]);
                }
            }
        }

        List<List<Integer>> ans=new ArrayList<>(output);
        return ans;
    }
}