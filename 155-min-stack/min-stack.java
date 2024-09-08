class Pair{
    int node;
    int min;
    public Pair(int node,int min){
        this.node=node;
        this.min=min;
    }
}
    class MinStack {
        Stack<Pair> st;
        int minVal=Integer.MAX_VALUE;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        minVal=Math.min(minVal,val);
        st.push(new Pair(val,minVal));
    }
    
    public void pop() {
        st.pop();
        if(st.isEmpty()){
            minVal=Integer.MAX_VALUE;
        }
        else{
             minVal=st.peek().min;
        }
       
    }
    
    public int top() {
        return st.peek().node;
    }
    
    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */