class Solution {
    public int maxArea(int[] heights) {

        int l = heights.length -1 ;
        int h1= 0; int h2 = heights.length -1;
        int maxArea=0;
        while(h1<=h2){
            int temp_maxArea = ((heights[h1]>heights[h2])? heights[h2]:heights[h1])*l;
            if (temp_maxArea>maxArea){
                maxArea = temp_maxArea;}
                h1++;
                l--;


            if (h2-h1==0 ){
                h1=0;
                h2--;
                l = h2;
            }

        }
        return maxArea;
    }
}
