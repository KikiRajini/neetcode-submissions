class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();

                if(s.equals("+")) stack.push(a+b); //== wont work here
                else if(s.equals("-")) stack.push(a-b);
                else if(s.equals("*")) stack.push(a*b);
                else stack.push(a/b);//a /b not b/a

            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
