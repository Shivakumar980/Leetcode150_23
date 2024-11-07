class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int i=0;
        int sign=1;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i<n &&s.charAt(i)=='+' ){
            i++;
        }
        else if(i<n &&s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        long num=0;
        while(i<n && Character.isDigit(s.charAt(i))){
           int digit=s.charAt(i)-'0';
             if ((num*10)+digit > Integer.MAX_VALUE ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
           
             num=(num*10)+digit;
            i++;
        }
        return (int)(num*sign);
    }
}