class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs= new HashSet<>();

        for(int num: nums){
            hs.add(num);
        }
        int n= nums.length;
        int max_streak=0;
        for(int num:hs){
            if(!hs.contains(num-1)){
                int curr_streak=1;
                while(hs.contains(num+1)){
                    curr_streak+=1;
                    num+=1;
                }
                max_streak= Math.max(max_streak,curr_streak);

            }
        }
        return max_streak;
    }
}