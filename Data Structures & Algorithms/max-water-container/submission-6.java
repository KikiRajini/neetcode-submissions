class Solution {
    public int maxArea(int[] heights) {
        int forward=0;
        int reverse=heights.length -1;
        int maxWater =0;
        
        while(reverse>forward){
            int water=Math.min(heights[reverse], heights[forward])*(reverse-forward);
            maxWater= Math.max(maxWater,water);
            if(heights[reverse]>=heights[forward]){
                forward++;
            }else{
                reverse--;
            }

        }
        return maxWater;
    }
}
