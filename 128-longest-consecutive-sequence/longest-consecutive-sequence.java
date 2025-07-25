class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n=nums.length;
        HashSet<Integer> hs= new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        int longest=0;
        for(int num: hs){
            if(hs.contains(num-1)){
                continue;
            }
            int temp=num;
            int streak=0;
            while(hs.contains(temp)){
                streak+=1;
                longest=Math.max(streak, longest);
                temp=temp+1;
            }
        }
        return longest;
    }
}