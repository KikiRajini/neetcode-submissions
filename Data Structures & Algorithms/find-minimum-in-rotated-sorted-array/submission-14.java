class Solution {
    public int findMin(int[] nums) {
      int min = nums[0];
        if(nums[nums.length -1]>nums[0]){return nums[0];}
        if(nums.length==1){return nums[0];}
        //rotated
        //min in rotated array -> left>mid<mid +1

//2,3,4,5,6,1 -> nums[0]<nums[mid] -> start = mid+1
//6,1,2,3,4,5 -> nums[0]>nums[mid] -> end = mid -1;

        int left=0; int right = nums.length -1;
        
        while(left<=right){
            int mid = (left+right)/2;
            min = Math.min (min,nums[mid]);
            if(nums[0]<nums[mid]){
                left= mid+1;
            }else if(nums[0]>nums[mid]){
                right= mid-1;
            }else{
                 min = Math.min (min,nums[1]);
                 break;
            }
                    }
                    return min;


    }
}
