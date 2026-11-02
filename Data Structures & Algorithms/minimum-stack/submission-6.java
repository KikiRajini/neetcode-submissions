class MinStack {
    Deque<Integer> minStack;
    Deque<Integer> stack;

    public MinStack() {
       minStack = new ArrayDeque<>();
       stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
       stack.push(val);
       minStack.push(Math.min(minStack.peek()==null? val:minStack.peek(),val));
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
