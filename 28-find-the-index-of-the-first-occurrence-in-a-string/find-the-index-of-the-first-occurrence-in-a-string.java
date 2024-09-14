class Solution {
    public int strStr(String haystack, String needle) {
        int partLength=needle.length();
        int n=haystack.length()-partLength;
        
        for(int i=0;i<=n;i++){
            if(haystack.substring(i,i+partLength).equals(needle)){
                return i;
            }
        }
    return -1;
      
        
    }
}