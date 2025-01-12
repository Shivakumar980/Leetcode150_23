class Solution {
    public boolean canConstruct(String s, int k) {
        int n= s.length();
        if(n<k)  return false;

        int[] map= new int[26];

        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        int count=0;

        for(int i=0 ;i<26; i++){
            if(map[i]%2==1){
                count++;
            }
        }
        return count<=k;
    }
}