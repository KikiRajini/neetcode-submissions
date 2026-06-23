class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operations = new HashSet<>();
        operations.add("+");operations.add("-");operations.add("*");operations.add("/");
        Deque<Integer> intStack = new ArrayDeque<>();
        for(String s : tokens){
            int computed = 0;
            if(operations.contains(s)){
                int second = intStack.pop();
                int first = intStack.pop();
                if(s.equals("+")){computed = first+second;}
                else if(s.equals("-")){computed = first-second;}
                else if (s.equals("*")){computed = first*second;}
                else if(s.equals("/")){computed = first/second;}
                intStack.push(computed);
            }else{
                intStack.push(Integer.valueOf(s));
            }
        }
        return intStack.pop();

    }
}
