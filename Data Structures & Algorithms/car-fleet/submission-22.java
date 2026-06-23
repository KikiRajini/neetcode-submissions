public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       double[][] fleet = new double[position.length][2];
       int result =1;
       Stack<Double> stack = new Stack<>();
       for(int i=0; i< position.length;i++){
        fleet[i][0]=position[i];
        fleet[i][1]=(double)(target-position[i])/speed[i];
       }
       Arrays.sort(fleet, (a,b)->(Double.compare(b[0],a[0])));
//8 - 1
//6 - 1.2
       for(double[] f: fleet){
        if(stack.isEmpty()){
            stack.push(f[1]);
        }else{
        if(f[1]>stack.peek()){
        result++;
        stack.push(f[1]);
        }
        }
       }
       return result;
    }
}