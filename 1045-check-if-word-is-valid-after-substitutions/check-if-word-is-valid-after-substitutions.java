class Solution {
    public boolean isValid(String s) {
        StringBuilder sb=new StringBuilder(s);

        while(sb.length()!=0){
            if(sb.toString().contains("abc")){
                int startIndex = sb.indexOf("abc");
                sb.delete(startIndex, startIndex + 3);
            }
            else{
                return false;
            }
        }
        return true;
    }
}