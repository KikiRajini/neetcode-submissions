class MinStack {
    Deque<Integer> minStack;
    Deque<Integer> stack;

    public MinStack() {
       minStack = new ArrayDeque<>();
       stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){minStack.push(val);}
        else{
            int min = Math.min(val,minStack.peek());
            minStack.push(min);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
       return minStack.peek();
    }
}
