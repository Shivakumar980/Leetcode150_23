class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1) return s.length(); 
        int start=0;
        int end=0;
        int len=0;
        HashSet<Character> hs=new HashSet<>();
        while(end<s.length()){
            while(hs.contains(s.charAt(end))){
                hs.remove(s.charAt(start));
                len=Math.max(end-start,len);
                start+=1;
                //end+=1;
            }
            
                hs.add(s.charAt(end));
                end+=1;
        }
         return Math.max(len,end-start);
    }
}