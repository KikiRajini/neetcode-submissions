class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int[][] cars = new int[position.length][2];
       int fleet = 0;
       for(int i =0; i< position.length; i++){
            cars[i][0] = target - position[i];
            cars[i][1] = speed[i];
       }

       Arrays.sort(cars, (a,b) -> Integer.compare(a[0],b[0]));
       double time = Integer.MIN_VALUE;
       for(int[] car : cars){
           
           double tempTime = (double) car[0]/car[1];
           if(tempTime>time){
           fleet++;
           time = tempTime;
           }
       }

       return fleet;

    }
}
