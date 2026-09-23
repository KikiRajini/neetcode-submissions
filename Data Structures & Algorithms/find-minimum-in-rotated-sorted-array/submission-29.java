class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Base case: array isn't rotated
        if (nums[left] <= nums[right]) return nums[left];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Explicit check if mid is the inflection point (minimum)
            if (mid > 0 &&  nums[mid - 1] > nums[mid] ) {
                return nums[mid];
            }

            // Decide which half to move past
            if (nums[mid] > nums[right]) {//right is not sorted -- so value will be in right
                left = mid + 1; // Both pointers move past mid
            } else {//right is sorted -- so it will be ever increasing, left has the min
                right = mid - 1; // Both pointers move past mid
            }
        }

        return -1;
    }
}