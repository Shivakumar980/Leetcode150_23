class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int right=0;
        HashSet<Character> hs= new HashSet<>();
        int maxlength=0;
        while(right<n){
            char c=s.charAt(right);
            while(hs.contains(c)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(c);
            maxlength=Math.max(maxlength, right-left+1);
            right++;

        
    }
    return maxlength;
    }
}