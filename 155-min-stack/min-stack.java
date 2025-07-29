class Pair{
    int element;
    int mini;
    public Pair(int element, int mini){
        this.element=element;
        this.mini=mini;
    }
}
class MinStack {

    private Stack<Pair> st;
    int local_minimum;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            local_minimum=Integer.MAX_VALUE;
        }
        local_minimum=Math.min(val, local_minimum);
        st.push(new Pair(val, local_minimum));
    }
    
    public void pop() {
        st.pop();
        if(!st.isEmpty()){
        local_minimum=  st.peek().mini;
        }
    }
    
    public int top() {
       return st.peek().element;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            return st.peek().mini;
        }
        else{
            return -1;
        }
        
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