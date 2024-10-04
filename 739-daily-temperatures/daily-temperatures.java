
class Pair{
    int temp;
    int index;
    public Pair(int temp,int index){
        this.temp=temp;
        this.index=index;
    }
}
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length-1;
        int[] res=new int[n+1];
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(temperatures[n],n));
        for(int i=n-1;i>=0;i--){
           

                while(!st.isEmpty() && st.peek().temp<=temperatures[i]){
                    st.pop();
                    }
                
                if(st.isEmpty()){
                    res[i]=0;
                    //System.out.println(st.size());
                }
                else{
                    //System.out.println(st.size());
                    res[i]=st.peek().index-i;
                    //System.out.println("in else");
                }
            st.push(new Pair(temperatures[i],i));
        }
        
        return res;
    }
}