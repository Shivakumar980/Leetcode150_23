class Solution {
    public boolean checkValidString(String s) {
        int minOpen=0;
        int maxOpen=0;
        int n=s.length();
        for(int i=0; i<n ;i++){
            char ch=s.charAt(i); 
            if(ch=='('){
                minOpen+=1;
                maxOpen+=1;
                }

            else if(ch==')'){
                minOpen-=1;
                maxOpen-=1;
            } 
            else {
                minOpen-=1;
                maxOpen+=1;
            }  
            if(maxOpen<0){
                return false;
            }
            minOpen=Math.max(minOpen,0);
        }
        return minOpen==0;
    }
}