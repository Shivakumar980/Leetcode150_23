class Solution {
    public int myAtoi(String s) {

        s=s.trim();
        if(s.isEmpty()) return 0;
        int sign=1;
        int i=0;
        long result=0;
        if(s.charAt(0)=='-'){
            sign=-1;
            i++;
        }
        else if(s.charAt(0)=='+'){
            i++;
        }
        int n=s.length();

        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            result=(10*result)+digit;
             if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
    
        


        return (int)result*sign;
    }
}