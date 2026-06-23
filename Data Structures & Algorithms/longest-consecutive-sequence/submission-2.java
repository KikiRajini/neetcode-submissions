class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        //2,3,4,5,10,20
        int count=0;
        int highestCount=0;
        for(int i =0; i< nums.length; i++){
            if(i !=0 && nums[i-1] != nums[i] && nums[i]-nums[i-1]==1){
                count++;
            } else if (i !=0 && nums[i-1] == nums[i]) {
                continue;}
            else if(i==0){count =1;}
            else{
                highestCount = highestCount>count? highestCount : count;
            count=1;}
            
        }
        highestCount = highestCount>count? highestCount : count;
        return highestCount;
    }
}
