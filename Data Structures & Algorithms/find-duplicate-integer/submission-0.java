class Solution {
    public int findDuplicate(int[] nums) {
        int first =0;
        int second =first+1;

        while(first<second ){
            
        
                if(second>=nums.length){
                    first= first+1;
                    second = first+1;
                }else if(nums[first]==nums[second]){
                return nums[first];
                }else{
                    second = second+1;
                }
            
        }
        return 0;
    }
}
