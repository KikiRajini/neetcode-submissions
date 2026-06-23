class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> track = new HashMap<>();
        int temptarget =0;
        for(int i=0; i<nums.length; i++){
            temptarget = target - nums[i];
            if(track.containsKey(temptarget)){
                return new int[]{track.get(temptarget),i};
            }else{
                track.put(nums[i],i);
            }
        }
        return new int[]{0};
    }
}
