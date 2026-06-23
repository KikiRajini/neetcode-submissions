class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        //o/p[i]= product of the values to the left * to the right;
        //prefix*suffix
        //prefix
        output[0]=1;
        for(int i =1; i<nums.length; i++){
            output[i]= output[i-1]*nums[i-1];
        }
        //suffix
        int right=1;
        for(int i = nums.length -1; i>=0; i--){
            output[i] = output[i]*right;
            right = right * nums[i];
        }
        return output;
    }
}  
