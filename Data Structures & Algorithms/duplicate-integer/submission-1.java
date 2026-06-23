class Solution {
    public boolean hasDuplicate(int[] nums) {
         int j=0; boolean found = false;
        for (int i=0; i< nums.length; i++){
          for (j=i; j< nums.length;j++){
            if (nums[i] == nums[j] && i!= j){
                found = true;
                System.out.println("true");
            }
          }
          if (!found == true) {
            System.out.println("true");
            }



        }
        return found;
    }
}
