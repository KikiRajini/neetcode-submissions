class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int first = 0;
      int last = numbers.length - 1;
      while(first<last ){
        int sum = numbers[first]+numbers[last];

        if(sum>target){
            last--;
        }else if(sum<target){
            first++;
        }else{
            return new int[]{first+1,last+1};
        }
      }
      return new int[]{-1,-1};
    }
}
