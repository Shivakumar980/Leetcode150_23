class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        int n=s.length();
        HashSet<Character> hs=new HashSet<>();
        int maxCount=0;
        while(right<n){
            while(hs.contains(s.charAt(right)) && left<right){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
           
            maxCount=Math.max(maxCount,right-left+1);
            right++;
        }
       return maxCount;
    }
    
}