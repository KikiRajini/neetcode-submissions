class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zero = -1;
        int secondZero =-1;
        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                total = total * nums[i];
            } else if (zero == -1 && secondZero == -1 && nums[i] == 0) {
                zero = i;
            } else if( zero != -1 && secondZero ==-1){
                return result;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (zero != -1) {
                if (j == zero) {
                    result[j] = total;
                } else {
                    result[j] = 0;
                }
            } else {
                result[j] = total/nums[j] ;
            }
        }

        return result;

    

    //     int[] result = new int[nums.length];
    //     Arrays.fill(result,1);
    //     for(int i = 0; i<nums.length; i++){
    //         for(int j = 0; j<nums.length; j++){
    //             if (i!=j){
    //                 result[j] = result[j]*nums[i];
    //             }
    //         }
    //     }
    // return result;
}  
}