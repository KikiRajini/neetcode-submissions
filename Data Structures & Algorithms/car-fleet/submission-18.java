public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        int fleet=1;
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            double time = (double) (target - p[0]) / p[1];//4.5
            
            if(!stack.isEmpty() && time>stack.peek()){
                fleet++;
                stack.push(time);
            }else if(!stack.isEmpty() && time<=stack.peek()){
                stack.push(stack.peek());
            }
            else{
                stack.push(time);//4 ->3
            }
           
        }
        return fleet;
    }
}