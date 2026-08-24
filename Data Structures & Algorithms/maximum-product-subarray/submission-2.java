class Solution {
    public int maxProduct(int[] nums) {
        int currentMax  = nums[0];
        int currentMin = nums[0];
        int max = nums[0];

        for(int i = 1; i< nums.length; i++){
            int n = nums[i];

            int tempMax = Math.max(n,Math.max(n*currentMax,n*currentMin));
            currentMin = Math.min(n,Math.min(n*currentMax,n*currentMin));
            currentMax = tempMax;
            max = Math.max(currentMax,max);
        }



        return max;
        
    }
}
