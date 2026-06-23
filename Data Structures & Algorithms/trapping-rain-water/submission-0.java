class Solution {
    public int trap(int[] height) {
            int left_max = 0;
            int right_max =0;
            int[] leftArr = new int[height.length];
            int[] rightArr = new int[height.length];

            for(int i =0; i<height.length; i++){
                int j= height.length -1 -i;
                if(i==0){
                    leftArr[i] = 0;
                    rightArr[j] = 0;
                } else{
                    left_max = Math.max(left_max,height[i-1]);
                    leftArr[i] = left_max;
                    right_max = Math.max(right_max,height[j+1]);
                    rightArr[j]= right_max;
                }

            }
            int vol =0;
            for(int j =0; j<height.length; j++){
                int min = Math.min(leftArr[j], rightArr[j]);
                if(min > height[j]){
                    vol = vol + (min-height[j])*1;
                }
            }

            return vol;
        }
}
