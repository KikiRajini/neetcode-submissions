class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] output = new int[temperatures.length];
        for(int i=0; i< temperatures.length; i++){
           
            while(!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                int pair[] = stack.pop();
                output[pair[1]]=i-pair[1];
            }
                stack.push(new int[]{temperatures[i],i});}
           
        
    return output;

        }
    
}
