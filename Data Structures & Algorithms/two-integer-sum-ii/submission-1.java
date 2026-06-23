class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int i = 0; int j = length-1;
        while(i<j && i!=j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }else if(numbers[i]+numbers[j]<target){
                i++;
                continue;
            }else{
                j--;
                continue;
            }
        }
        return new int[]{0,0};

    }
}
