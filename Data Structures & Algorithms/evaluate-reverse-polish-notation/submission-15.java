class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int result ;
                if(s.equals("+")){
                    result = a+b;
                }else if(s.equals("-") ){
                    result = a-b;
                }else if( s.equals("*") ){
                    result = a*b;
                }else{
                    result = a/b;
                }
                stack.push(result);
            }else{
            stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
