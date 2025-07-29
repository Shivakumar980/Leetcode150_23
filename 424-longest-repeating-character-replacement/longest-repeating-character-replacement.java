class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();
        HashMap<Character, Integer> freqMap= new HashMap<>();
        int left=0;
        int right=0;
        int maxFreq=0;
        int maxlength=0;
        while(right<n){
            char ch= s.charAt(right);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,freqMap.get(ch));

            while((right-left+1)-maxFreq>k){
                int count=freqMap.get(s.charAt(left));
                count-=1;
                if(count==0){
                    freqMap.remove(s.charAt(left));
                }
                freqMap.put(s.charAt(left),count);
                left++;
            }
            maxlength=Math.max(maxlength, right-left+1);
            right++;
        }
        return maxlength;
    }
}