class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[] freqMap = new int[26];
        int left=0;
        int right=0;
        int maxfreq=0;
        int maxlength=0;
        while(right<n){
            char ch= s.charAt(right);
            freqMap[ch-'A']++;
            maxfreq=Math.max(freqMap[ch-'A'],maxfreq);
            while((right-left+1)-maxfreq>k){
                freqMap[s.charAt(left)-'A']--;
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
            right++;
        }

        return maxlength;
        
    }
}