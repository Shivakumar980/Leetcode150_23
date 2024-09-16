class Solution {
   
    public boolean repeatedSubstringPattern(String s) {
          String repeatedString= s+s;

        repeatedString=repeatedString.substring(1,repeatedString.length()-1);
        
        return repeatedString.contains(s);
    }
}