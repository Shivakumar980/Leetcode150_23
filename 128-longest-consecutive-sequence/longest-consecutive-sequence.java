class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }
        int cnt=0;
        int ans=0;
        for(int num:hs){
            if(!hs.contains(num-1)){
                int x=num;
                while(hs.contains(x)){
                    cnt++;
                    x++;
                }
            }
            ans=Math.max(ans,cnt);
            cnt=0;
        }
        return ans;
    }
    
}