class Solution {
    public int trap(int[] height) {
        int l =0; int r = height.length -1;
        int lVal = height[l]; int rVal = height[r];
        int vol = 0;
        while(l<r){
            if(lVal<=rVal){
                l++;
                int extraVol =  Math.min(lVal,rVal) - height[l];
                if (extraVol <0){
                    extraVol =0;
                }
                vol = vol + extraVol;
                lVal = Math.max(lVal,height[l]);
            }else{
                r--;
                int extraVol =  Math.min(lVal,rVal) - height[r];
                if (extraVol <0){
                    extraVol =0;
                }
                vol = vol + extraVol;
                rVal = Math.max(rVal,height[r]);
            }
        }
        return vol;
    }
}
