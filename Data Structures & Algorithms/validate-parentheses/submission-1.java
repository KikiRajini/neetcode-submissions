class Solution {
     public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }else{
            Stack<Integer> stack = new Stack<>();
            for (char c: s.toCharArray()){
                if(!stack.isEmpty() && stack.peek()==(((int)c)-2)){
                    stack.removeElement((Integer)((int)c)-2);
                }else if(!stack.isEmpty() && stack.peek()==(((int)c)-1)) {
                    stack.removeElement((Integer) ((int) c) - 1);
                }else{
                    stack.push((int)c);
                }
            }
            if(stack.isEmpty()){
                return true;
            }
        }
        return false;
    }
}
