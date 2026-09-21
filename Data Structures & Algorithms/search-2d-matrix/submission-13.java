class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; int col = matrix[0].length;
        int left = 0;
        int right = row*col - 1;
        while(left<=right){
            int middle = (left + right)/2;
            int r = middle/col;
            int c = middle % col;

            if(matrix[r][c]==target){return true;}
            else if (matrix[r][c]<target){left = middle +1;}
            else{right = middle - 1;}

        }

        return false;
    }
}
