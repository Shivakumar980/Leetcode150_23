class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();

        Stack<Integer> openBraces=new Stack<>();
        Stack<Integer> unlocked=new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'){
                unlocked.push(i);
            }
            else if(s.charAt(i)=='('){
                openBraces.push(i);
            }
            else if(s.charAt(i)==')'){
                if(!openBraces.isEmpty()){
                    openBraces.pop();
                }
                else if(!unlocked.isEmpty()){
                    unlocked.pop();
                }
                else{
                    return false;
                }
            }
        }
     
        while(!unlocked.isEmpty() && !openBraces.isEmpty() && unlocked.peek()>openBraces.peek()){
           
                unlocked.pop();
                openBraces.pop();
        }
        
        if(!openBraces.isEmpty()){
            return false;
        }
        return true;
    }
}