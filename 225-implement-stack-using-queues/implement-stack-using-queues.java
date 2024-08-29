class MyStack {

    private Deque<Integer> deque;
    
    public MyStack() {
        deque = new LinkedList<>();

    }
    
    public void push(int x) {
        deque.add(x);
    }
    
    public int pop() {
        int element=deque.removeLast();
        return element;
    }
    
    public int top() {
        int element=deque.peekLast();
        return element;
    }
    
    public boolean empty() {
        if(deque.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */