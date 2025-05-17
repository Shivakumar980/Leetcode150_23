class Pair{
    int temp;
    int index;

    public Pair(int temp, int index){
        this.temp=temp;
        this.index=index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n= temperatures.length;
        int[] res= new int[n];
        Stack<Pair> st= new Stack<>();
        for(int i=n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && st.peek().temp<= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=st.peek().index-i;
            }

            st.push(new Pair(temperatures[i],i));
        }
        return res;
    }
}