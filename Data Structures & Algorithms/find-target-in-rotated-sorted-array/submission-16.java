class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 1. Check if the left half is sorted
            if (nums[mid] > nums[right]) { //right is rotated
            //if you check wrt left you must check nums[left] <= nums[mid] because now min can be mid itself if left = min --so always remeber to check right
            //When an array is rotated, the maximum value is on the left of the pivot point, and the minimum value is on the right.
            //If nums[mid] > nums[right] (7>2): There is a "cliff" (drop-off) between mid and right. The minimum MUST be to the right of mid.If nums[mid] <= nums[right] (1≤2): The section from mid to right is perfectly smooth and sorted. The minimum CANNOT be to the right of mid—it must be at mid or to its left. Notice how comparing against right gives you an unambiguous decision every single time, even if the current sub-window isn't rotated!


                // Is target within the bounds of this sorted left half?
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // 2. Otherwise, the right half MUST be sorted
            else {
                // Is target within the bounds of this sorted right half?
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}