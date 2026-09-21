class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();

                if(s.equals("+")) stack.push(a+b); //== wont work here
                else if(s.equals("-")) stack.push(b-a);//b-a
                else if(s.equals("*")) stack.push(a*b);
                else stack.push(b/a);// b/a

            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
