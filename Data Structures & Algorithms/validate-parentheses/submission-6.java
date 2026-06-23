class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')','('); charMap.put(']','['); charMap.put('}','{');
        for(Character c: s.toCharArray()){
            if(!stack.isEmpty() && charMap.containsKey(c) && stack.peek()==charMap.get(c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
