class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // 1. Identify which side is sorted
            if (nums[left] <= nums[mid]) { 
                // Left side is sorted (e.g., [4, 5, 6, 7, 0])
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target is in the sorted range
                } else {
                    left = mid + 1;  // Target is in the rotated side
                }
            } else { 
                // Right side is sorted (e.g., [6, 7, 0, 1, 2])
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target is in the sorted range
                } else {
                    right = mid - 1; // Target is in the rotated side
                }
            }
        }
        return -1;
    }
}