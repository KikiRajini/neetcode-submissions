class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      //int k = 1 to max value in pile
      int left = 1;
      int right = 0;
      for(int p : piles){
        right = Math.max(p,right);
      }
      int k = right;

      while(left<=right){
        int middle = left + (right - left)/2;
        int timeTaken = 0;

        for(int pile : piles){
            //uses integer arithmetic to compute ⌈p/middle⌉ without relying on   floating-point conversions.
            timeTaken = timeTaken + ((pile + middle - 1) /middle);
        }
        if(timeTaken <= h){
            k =  middle;
            right = middle -1;
        }else{
            left = middle +1;
        }
      }

      return k;
    }
}