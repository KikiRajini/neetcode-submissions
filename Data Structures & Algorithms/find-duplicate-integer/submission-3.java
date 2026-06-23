class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast==slow){
                break;
            }
        }
        int slow1= 0;
        while(true){
            slow=nums[slow];
            slow1=nums[slow1];
            if(slow==slow1){
                break;
            }
           
        }
   
    return slow;
    }
}
