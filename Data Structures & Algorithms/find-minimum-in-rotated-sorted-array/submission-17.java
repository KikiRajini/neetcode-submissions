class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element, 
            // the minimum must be in the right half (excluding mid)
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, minimum is at mid or in the left half
            else {
                right = mid;
            }
        }

        // When left == right, we have converged on the minimum element
        return nums[left];
    }
}