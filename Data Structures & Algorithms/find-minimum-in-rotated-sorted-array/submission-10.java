class Solution {
    public int findMin(int[] nums) {
        // //1 2 3 4 5 6 - size =5
        // end>start -> not rotated

        // target = 1
        // post+rotation - length-1
        // //4 times ->  3 4 5 6 1 2 
        // end<start -> rotated
        
        // int first = 0;
        // int last = nums.length -1; //5
        // int mid = (first+last)/2; //2 ->5
        int first =0;//0
        int last = nums.length-1; //6
        int small = nums[(first+last)/2]; //7
        if(nums.length ==1){return nums[0];}
        if(nums[last]>nums[first]){return nums[first];}
        while(last>=first){
            int mid = (first+(last))/2;//3
            if(mid-1 >=0 && nums[mid-1]>nums[mid]){
                return nums[mid];
            }else if(mid+1<nums.length && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            else if (nums[mid]<nums[0]){
                 last= mid-1;
            }else{
                first = mid+1;
               
            }
        }
          return small;


    }
}
