class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> tracker = new HashSet<>();
        for(int i :  nums){
            if(tracker.contains(i)){
                return true;
            }else{
                tracker.add(i);
            }
        }
        return false;
    }
}