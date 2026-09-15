class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i<temperatures.length; i++){
           //we track the index instead of the value as it's easy to get the value with the index
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){//i=3
                int idx = stack.pop();//2
                result[idx] = i - idx;
            }
             stack.push(i); //1,2
           
        }

       return result;
    }
}
