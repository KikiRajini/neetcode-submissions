class Solution {
    public int evalRPN(String[] tokens) {
        String[] op = {"+","-","*","/"};
        Stack<Integer> stack = new Stack<>();
        int result =0;
        int div=0;
        for(String token: tokens){
            if(token.equals("+")){
                result = stack.pop()+stack.pop();
                stack.push(result);
            }else if(token.equals("*")){
                result = stack.pop()*stack.pop();
                stack.push(result);
            }else if(token.equals("-")){
                result= -stack.pop()+stack.pop();
                stack.push(result);
            }else if(token.equals("/")){
                div= stack.pop();
                result= stack.pop()/div;
                stack.push(result);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
        
    }
}
