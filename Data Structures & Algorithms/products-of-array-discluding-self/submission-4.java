class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                if (i!=j){
                    result[j] = result[j]*nums[i];
                }
            }
        }
    return result;
}  
}