class Pair{
    int element;
    int min;
    public  Pair(int element, int min){
        this.element=element;
        this.min=min;
    }
}
class MinStack {

    Stack<Pair> st;
    public MinStack() {
       st= new Stack<>(); 
    }
    
    public void push(int val) {
        int mini= Integer.MAX_VALUE;
        if(st.isEmpty()){
            mini=val;
        }
        else{
             mini= Math.min(val, st.peek().min);
        }
       
        st.push(new Pair(val, mini));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().element;
    }
    
    public int getMin() {
        return st.peek().min;
        
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