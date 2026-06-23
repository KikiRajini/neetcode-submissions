class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
    Stack<int[]> stack = new Stack<>();
    for (int i=0; i< temp.length; i++){
        while(!stack.isEmpty() && stack.peek()[1]<temp[i]){
            int[] p = stack.pop();
            res[p[0]] = i - p[0];
        }
        stack.push(new int[]{i,temp[i]});
    }
    return res;

}}
