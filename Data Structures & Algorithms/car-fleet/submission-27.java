class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
          for(int i = 0; i<position.length; i++){
            cars[i][0] = target - position[i];
            cars[i][1] = speed[i];
          }

          Arrays.sort(cars, (a,b)->(a[0]-b[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for(int[] car: cars){
            double t = (double)(car[0])/car[1];
            if(stack.isEmpty()){stack.push(t);}
            else{
                if(t>stack.peek()){stack.push(t);}
            }
        }

        return stack.size();

    }
}
