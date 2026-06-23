class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> trace = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int diff = target - nums[i];
            if(trace.containsKey(diff)){return new int[]{trace.get(diff),i};}
            trace.put(nums[i],i);
        }
        return new int[]{-1,-1};
       
    }
}
