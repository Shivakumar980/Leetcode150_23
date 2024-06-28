class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        int maxCount=0;
        while(right<n){
            if(hm.containsKey(s.charAt(right))){
                left=Math.max(left,hm.get(s.charAt(right))+1);
            }
            hm.put(s.charAt(right),right);
            maxCount=Math.max(maxCount,right-left+1);
            right++;
        }
       return maxCount;
    }
    
}