class Pair{
    int element;
    int minimum;

    public Pair(int element, int minimum){
        this.element=element;
        this.minimum=minimum;
    }
}
class MinStack {
    
    int minval;
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
        minval=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        minval=Math.min(minval,val);
        st.push(new Pair(val,minval));
    }
    
    public void pop() {
        st.pop();
        if(st.isEmpty()){
             minval=Integer.MAX_VALUE;
        }
        else{
            minval=st.peek().minimum;
        }
    }
    
    public int top() {
        return st.peek().element;
    }
    
    public int getMin() {
        return st.peek().minimum;
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