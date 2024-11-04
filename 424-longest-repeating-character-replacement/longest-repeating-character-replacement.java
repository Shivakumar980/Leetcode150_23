class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxlen=0;
        int[] freqMap=new int[26];
        int maxf=0;

        while(right<n){
            int c=s.charAt(right)-'A';
            freqMap[c]++;
            maxf=Math.max(maxf,freqMap[c]);
            while ((right-left+1)-maxf>k && left<right){
                freqMap[s.charAt(left) - 'A']--;
                for(int i=0;i<26;i++){
                    maxf=Math.max(maxf,freqMap[i]);
                }
                left++;
            }
            if((right-left+1)-maxf<=k){
                maxlen=Math.max(maxlen,right-left+1);
            }
            right++;
        }

        return maxlen;
    }
}