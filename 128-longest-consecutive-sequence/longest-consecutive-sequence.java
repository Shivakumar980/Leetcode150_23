class Solution {
    public int longestConsecutive(int[] nums) {
            int n=nums.length;
            int longest=0;
            HashSet<Integer> hs=new HashSet<>();
            for(int num:nums){
                hs.add(num);
            }

            for(int i=0;i<n;i++){
                if(!hs.contains(nums[i]-1)){
                    int x=nums[i];
                    int cnt=1;
                    while(hs.contains(x+1)){
                        x=x+1;
                        cnt++;
                    }
                    longest=Math.max(cnt,longest);
                }
            }
        return longest;
    }
}