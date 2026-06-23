class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean zeroOnce = false;
        int zeroOncePos = -1;
        boolean zeroTwice= false;
        int product =1;
        for(int i =0; i<nums.length; i++){
            if(nums[i]==0 && !zeroOnce){
                zeroOnce = true;
                zeroOncePos = i; 
            }else if(nums[i]==0 && zeroOnce && !zeroTwice){
                zeroTwice= true;
                break;
            }else {
                product = product*nums[i];
            }
        }

        int[] result = new int[nums.length];
        if(zeroTwice){return result;}
        if(zeroOnce){result[zeroOncePos]=product; return result;}
        for(int j =0; j<nums.length; j++){
                result[j]= product/nums[j];
            }
        

        return result;
    }
}  
