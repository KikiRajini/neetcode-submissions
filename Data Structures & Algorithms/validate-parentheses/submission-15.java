class Solution {
    public boolean isValid(String s) {
       Map<Character,Character> map = new HashMap<>();
       map.put('}','{');
       map.put(')','(');
       map.put(']','[');
       Deque<Character> stack = new ArrayDeque<>();
       for(Character c: s.toCharArray()){
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(map.get(c) == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
       }
  
    return stack.isEmpty();
    }
}
