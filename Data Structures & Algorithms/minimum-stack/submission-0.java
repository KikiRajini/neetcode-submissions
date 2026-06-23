class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack();
        stack = new Stack();

    }
    
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min((minStack.isEmpty()? val: minStack.peek()),val));
        
    }
    
    public void pop() {
        if(!minStack.isEmpty()){
        minStack.pop();}
        stack.pop();

       
    }
    
    public int top() {
        // minStack.peek();
       
        if(!stack.isEmpty()){
        return stack.peek();}
        else{return 0;}
    }
    
    public int getMin() {
        return minStack.isEmpty()? 0: minStack.peek();
    }
}
