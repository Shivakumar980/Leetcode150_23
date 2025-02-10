class Solution {
    public String clearDigits(String s) {

        StringBuilder sb= new StringBuilder();

        int n= s.length();
        int numCount=0;
        for(int i=n-1 ; i>=0 ;i--){
            if(Character.isDigit(s.charAt(i))){
                numCount++;
            }
            else if(!Character.isDigit(s.charAt(i)) && numCount>0 ){
                numCount--;
            }
            else{
                if(!Character.isDigit(s.charAt(i))){
                     sb.append(s.charAt(i));
                }  
            }
        }
        
        return sb.reverse().toString();
    }
}

