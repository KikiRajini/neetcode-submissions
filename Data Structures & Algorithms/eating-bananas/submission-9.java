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
            //uses integer arithmetic to compute ⌈pile/middle⌉ without relying on   floating-point conversions.
            timeTaken = timeTaken + ((pile + middle - 1) /middle);
            //example : rate is 3: for pile = 4,5,6 eating rate should be 2
            // (4 + 2) /3 == (5 + 2) / 3 == (6 + 2) /3
            //here we add 3-1 as min value needed for the number to reach next 3 value but not exceed it.
            
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