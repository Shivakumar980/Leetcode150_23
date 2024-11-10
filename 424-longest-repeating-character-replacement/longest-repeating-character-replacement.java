class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxlen=0;

        int[] freqMap=new int[26];
        int maxf=0;
        while(right<n){
            int index=s.charAt(right)-'A';
            freqMap[index]++;
            maxf= Math.max(freqMap[index],maxf);
            while((right-left+1)-maxf > k){
                freqMap[s.charAt(left)-'A']--;
                left++;
            }
            maxlen=Math.max(right-left+1 , maxlen);
            right++;
        }
        return maxlen;
        
    }
}