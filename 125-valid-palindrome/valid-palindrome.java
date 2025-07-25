class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        StringBuilder sb= new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int left=0;
        int right=sb.length()-1;
         s=sb.toString();
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}