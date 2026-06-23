class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int forward=0; int reverse= numbers.length -1;
       while(forward<reverse){
        if(numbers[forward]+numbers[reverse]==target){
            return new int[]{forward+1,reverse+1};
        }else if(numbers[forward]+numbers[reverse]<target){
            forward++;
        }else if(numbers[forward]+numbers[reverse]>target){
            reverse--;
        }
       } 
       return new int[]{-1,-1};
    }
}
