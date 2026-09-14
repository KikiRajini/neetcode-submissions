public class Solution {
    public int maxArea(int[] heights) {
      int maxVol =0;

      int left = 0; int right = heights.length-1;
      while(left<right){
        int vol = Math.min(heights[left],heights[right])*(right-left);
        maxVol= Math.max(vol,maxVol);
        if(heights[left]<heights[right]){left++;}
        else{right--;}
      }

      return maxVol;
    }
}