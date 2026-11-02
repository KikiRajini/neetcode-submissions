class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i<temperatures.length; i++){
           //we track the index instead of the value as it's easy to get the value with the index
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx = stack.pop();//lower temp index
                result[idx] = i - idx;//i is the higher temp now
            }
             stack.push(i); 
           
        }

       return result;
    }
}
