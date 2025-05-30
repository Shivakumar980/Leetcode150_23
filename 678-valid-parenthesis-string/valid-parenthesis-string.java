class Solution {
    public boolean checkValidString(String s) {
        int leftMin=0;
        int leftMax=0;

        int n=s.length();

        for(int i=0 ; i< n ; i++){
            char c=s.charAt(i);

            if(c=='('){
                leftMin++;
                leftMax++;
            }
            else if(c==')'){
                leftMin--;
                leftMax--;
            }
            else{
                leftMin--;
                leftMax++;
            }

            if(leftMax<0) return false;
            if(leftMin<0) leftMin=0;
        }
        return leftMin==0;
    }
}