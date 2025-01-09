class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;

        HashSet<Integer> hs=new HashSet<>();
        for(int num : nums ){
            hs.add(num);
        }

        int maxlength=0;
        for(int num: hs){
            if(!hs.contains(num-1)){
                int longestchunk= 1;

                while(hs.contains(num+1)){
                    longestchunk+=1;
                    num+=1;
                }
                maxlength= Math.max(maxlength,longestchunk);
            }
        }
        return maxlength;
        
    }
}