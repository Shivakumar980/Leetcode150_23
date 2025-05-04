class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n= nums.length;
      
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0 ; i< n ;i++){
            hs.add(nums[i]);
        }
        int longest=0;
        for(int num: hs){
            if(!hs.contains(num-1)){
                int current_streak=1;
                while(hs.contains(num+1)){
                    current_streak+=1;
                    num+=1;
                }
                longest= Math.max(longest, current_streak);
            }
        }

        return longest;

    }
}