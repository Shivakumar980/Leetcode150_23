class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int n=s.length();

        int[] smap= new int[26];

        for(int i=0; i< n; i++){
            smap[s.charAt(i)-'a']++;
            smap[t.charAt(i)-'a']--;
        }

        for(int i=0; i< 26 ;i++){
            if(smap[i]!=0) return false;
        }

        return true;

        
    }
}