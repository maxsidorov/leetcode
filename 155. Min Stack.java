class MinStack {
    
    static class Data {
        int x;
        int min;
    }
    
    Stack<Data> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        Data data = new Data();
        data.x = x;
        data.min = stack.isEmpty() ? x : Math.min(x, stack.peek().min);
        stack.push(data);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().x;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
