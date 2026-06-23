class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> result = new TreeMap();
      
   
        int fleet=0;
        for (int i =0; i<position.length; i++){
            result.put(target-position[i],speed[i]);
        }
        double timeMin = (double)result.firstKey()/result.get(result.firstKey());
        fleet = 1;
        for(int j : result.keySet()){
            if((double)j/result.get(j)> timeMin){
                fleet++;
                timeMin =(double)j/result.get(j);
            }
        }
        return fleet;
    }
}
