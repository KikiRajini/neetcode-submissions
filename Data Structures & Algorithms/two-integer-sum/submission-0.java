class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = {-1,-1};
    
       for (int i =0; i< nums.length; i++){
        for (int j=i; j<nums.length;j++){
            if (target-nums[i]==nums[j] && i!= j){
            System.out.println("i : " +i);
            System.out.println("j : " +j);
            sol[0]=i; sol[1]=j;
            System.out.println(sol[0]);
            break;}
                
        }
       } 
       System.out.println(sol);return sol;
    }
}
