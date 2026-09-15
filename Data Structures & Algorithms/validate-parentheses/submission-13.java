class Solution {
    public boolean isValid(String s) {
       Map<Character,Character> map = new HashMap<>();
       map.put('}','{');
       map.put(')','(');
       map.put(']','[');
       Deque<Character> stack = new ArrayDeque<>(); 
       for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                stack.push(c);
            }else if (stack.peek()==map.get(c)){
                stack.pop();
            }else{
                return false;
            }
       }

       if(stack.size()!=0){return false;}
    return true;
    }
}
