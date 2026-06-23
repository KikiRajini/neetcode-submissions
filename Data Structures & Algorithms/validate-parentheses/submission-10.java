class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> validPairs = new HashMap<>();
        validPairs.put('[',']');
        validPairs.put('{','}');
        validPairs.put('(',')');
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArr = s.toCharArray();
        for(char c: charArr){
            if(validPairs.containsKey(c)){
                stack.push(c);
            } else {
                if(!stack.isEmpty()){
                Character lastPushed = stack.pop();
                if(validPairs.get(lastPushed)!=c){
                    return false;}
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;

    }
}
