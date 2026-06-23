class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
  
        int [] prefix = new int[nums.length];

        int [] suffix = new int[nums.length];
  
       for(int i =0; i<nums.length; i++){
        if(i==0){
            prefix[0]= 1;
            suffix[nums.length-1] = 1;
            
        }else{
            prefix[i] = prefix[i-1]*nums[i-1];
            suffix[nums.length-i-1] = suffix[nums.length-i]*nums[nums.length-i];
           
        }
       }
       for(int j =0; j<nums.length;j++){ results[j]= prefix[j]*suffix[j];}

       return results;
    }
}  
