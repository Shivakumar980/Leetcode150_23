class Pair{
    int element;
    int index;
    public Pair(int element, int index){
        this.element=element;
        this.index=index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int[] result=new int[n];
        Stack<Pair> st=new Stack<>();
        for(int i=n-1; i >=0 ;i--){
            while(!st.isEmpty() && st.peek().element<=temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i]=0;
            }else{
                 result[i]=st.peek().index-i;
            }
            st.push(new Pair(temperatures[i],i));
        }
        return result;
    }
}