class Solution {
    public int search(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;

        while(left<=right){
            //If left and right are both large numbers, adding them together (left + right) exceeds Integer.MAX_VALUE. This causes the value to wrap around to a negative number, leading to array indexing errors or infinite loops.
            int middle = left + (right - left)/2;
            if(nums[middle]==target) return middle;
            else if (nums[middle]<target){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }

        return -1;
    }
}
