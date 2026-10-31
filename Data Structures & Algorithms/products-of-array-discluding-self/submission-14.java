class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] prefix = new int[nums.length];
       prefix[0] = 1;
       int i = 1;

       while(i<nums.length){
        prefix[i] = prefix[i-1]*nums[i-1];
        i++;
       }

       int suffix = 1;

       i = nums.length -1;
       while(i>=0){
        prefix[i] = prefix[i]*suffix;
        suffix = nums[i] * suffix;
        i--;
       }

       return prefix;
    }
}  
