class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start=0;
        int end= (row*col)-1;

        while(end>=start){
            int mid = (end+start)/2;
            int midValue = matrix[mid/col][mid%col];
            if(midValue==target){return true;}
            else if(midValue<target){start = mid+1;}
            else{end= mid-1;}
        }
        return false;

    }
}