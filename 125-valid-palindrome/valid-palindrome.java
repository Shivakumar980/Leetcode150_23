class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb= new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        String ss= sb.toString();

        int left=0;
        int right=ss.length()-1;

        while(left<=right){
            if(ss.charAt(left)!=ss.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}