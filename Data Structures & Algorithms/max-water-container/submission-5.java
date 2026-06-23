class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(heights[left], heights[right]);
            res = Math.max(res, area);



    if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }


        // int l = heights.length -1 ;
        // int h1= 0; int h2 = heights.length -1;
        // int maxArea=0;
        // while(h1<=h2){
        //     int temp_maxArea = ((heights[h1]>heights[h2])? heights[h2]:heights[h1])*l;
        //     if (temp_maxArea>maxArea){
        //         maxArea = temp_maxArea;}
        //         h1++;
        //         l--;


        //     if (h2-h1==0 ){
        //         h1=0;
        //         h2--;
        //         l = h2;
        //     }

        // }
        // return maxArea;
    
}
