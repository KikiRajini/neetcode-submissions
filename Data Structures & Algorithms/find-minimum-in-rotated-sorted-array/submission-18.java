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
//Use while (left <= right) when you move both pointers past mid (left = mid + 1 and right = mid - 1), usually when searching for a specific target value.
//Use while (left < right) when one pointer stays at mid (right = mid or left = mid), usually when shrinking a boundary to converge on an answer.