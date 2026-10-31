class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        
       int vol =0;
       int left =0;
       int right = height.length-1;
       int leftMax = height[left];
       int rightMax = height[right];

       while(left<right){
          if(height[left]<height[right]){
            left++;
            leftMax = Math.max(height[left],leftMax);
            vol = vol + leftMax - height[left];
          }else{
            right--;
            rightMax = Math.max(height[right],rightMax);
            vol = vol + rightMax - height[right];
          }
       }


       return vol;
    }
}
