class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated at all (already sorted)
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the inflection point (the 'dip')
            // Example: [4, 5, 1, 2, 3] -> mid is at 1, mid-1 is 5.
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Decide which half to search
            // If mid is greater than the rightmost element, the min must be on the right
            //[4, 5, 6, 7, 1, 2, 3]
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the min is on the left (including mid)
                //[6, 7, 1, 2, 3, 4, 5]
                right = mid - 1;
            }
        }
        return -1;
    }
}