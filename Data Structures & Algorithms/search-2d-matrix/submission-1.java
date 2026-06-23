class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart =0;
        int rowEnd = matrix.length -1;
        int colStart =0;
        int colEnd = matrix[0].length -1;

        int firstRow[] = matrix[0];
        int lastRow[] = matrix[rowEnd];
    

        while(rowStart<=rowEnd){
            int mid= (rowEnd+rowStart)/2;
            int[] midArr = matrix[mid];
            if(target-1<midArr[colEnd]&&target+1>midArr[colStart]){
                return binarySearch(midArr,target);
            }else if(target>midArr[colEnd]){
                rowStart=mid+1;
            }else{
                rowEnd= mid-1;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] input, int target){
        int start=0;
        int end= input.length;

        while(end>=start){
            int mid = (end+start)/2;
            if(target == input[mid]){
                return true;
            }else if(target>input[mid]){
                start= mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}
