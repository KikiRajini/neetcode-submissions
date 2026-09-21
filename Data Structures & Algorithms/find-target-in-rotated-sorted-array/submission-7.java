class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // 1. Check if the RIGHT half is sorted
            if (nums[middle] < nums[right]) {
                // Is target strictly WITHIN the bounds of the right half?
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;  // Search right
                } else {
                    right = middle - 1; // Search left
                }
            } 
            // 2. Otherwise, the LEFT half must be sorted
            else {
                // Is target strictly WITHIN the bounds of the left half?
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1; // Search left
                } else {
                    left = middle + 1;  // Search right
                }
            }
        }

        return -1;
    }
}