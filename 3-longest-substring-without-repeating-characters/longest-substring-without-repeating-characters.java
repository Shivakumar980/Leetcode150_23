class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxlen=0;
        HashSet<Character> hs=new HashSet<>();

        while(right<n){
            char c=s.charAt(right);
            while(hs.contains(c)){
                hs.remove(s.charAt(left));
                left++;

            }

            hs.add(c);
            maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}