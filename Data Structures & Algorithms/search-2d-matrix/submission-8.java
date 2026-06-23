class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int row = -1;

        // Binary search to find the correct row
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target > matrix[mid][n - 1]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                row = mid;
                break;
            }
        }

        if (row == -1) return false; // No valid row found

        // Binary search within the row
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
