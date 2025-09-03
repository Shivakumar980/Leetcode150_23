class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] smap= new int[26];

        for(int i=0; i< s.length(); i++){
            char chs=s.charAt(i);
            char cht=t.charAt(i);
            smap[chs-'a']++;
            smap[cht-'a']--;
        }

        for(int i=0; i<26; i++){
            if(smap[i]!=0) return false;
        }

        return true;

    }
}