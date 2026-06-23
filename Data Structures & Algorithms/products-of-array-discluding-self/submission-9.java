class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];

  
       for(int i =0; i<nums.length; i++){
        if(i==0){
            results[0]= 1;
            
        }else{
            results[i] = results[i-1]*nums[i-1];  
        }
       }
       //1 2 3 4
       int suffix=1;
       for(int j =nums.length-1; j>=0;j--){ 
        if(j==nums.length-1){results[j]=results[j];}
        else{
        suffix = suffix*nums[j+1];
        results[j]= results[j]*suffix;
        }
        }

       return results;
    }
}  
