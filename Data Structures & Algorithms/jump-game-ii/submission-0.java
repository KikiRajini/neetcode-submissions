class Solution {
    public int jump(int[] nums) {
        int jumps = 0; //min jumps

        int farthest = 0; //max I can move from a position
        int currEnd = 0; //when I have to jump


        for(int i = 0; i<nums.length-1 ; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currEnd){
                jumps++;
                currEnd = farthest;
            }

        }

        return jumps;



    }
}
