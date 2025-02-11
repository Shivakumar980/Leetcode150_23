class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st= new Stack<>();
        int strLength= s.length();
        int partLength= part.length();

        for(int index=0; index< strLength; index++){
            st.push(s.charAt(index));
            if(st.size()>=partLength && checkMatch(st, part, partLength)){
                for(int j=0; j<partLength; j++){
                    st.pop();
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    private boolean checkMatch(Stack<Character> st, String part, int partLength){
        Stack<Character> temp = new Stack<>();
        temp.addAll(st);

        for(int i= partLength-1 ; i>=0 ;i--){
            if(temp.isEmpty() ||  temp.peek()!= part.charAt(i)){
                return false;
            }
            temp.pop();
        }
        return true;
    }
}