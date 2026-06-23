class Solution {
    public int findMin(int[] nums) {
        Stack<Integer> track = new Stack<>();
        int min = nums[0];
        for(int i: nums){
            if(track.isEmpty()){
                track.push(i);
            }else{
                if(i == track.peek()+1){
                    track.push(i);
                }
                else{
                    min = Math.min(min,i);
                }
            }
        }
        return min;
    }
}
