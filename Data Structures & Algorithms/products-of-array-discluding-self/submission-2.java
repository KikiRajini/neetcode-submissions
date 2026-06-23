class Solution {
    public int[] productExceptSelf(int[] nums) {
        //0,8,0,0,1
        boolean hasZero = false;
        boolean hasMultipleZeroes = false;
        boolean hasOnlyZeroes = true;
        int[] output = new int[nums.length];
        List<Integer> zeros = new ArrayList<>();
        int product = 1;
        for(int i=0;i<nums.length; i++){
            if(nums[i]==0){product=product; hasZero=true; zeros.add(i);}
           else {product= product*nums[i]; hasOnlyZeroes= false;}
        }
        if(hasOnlyZeroes){
            return nums;
        }
        if(zeros.size()>1){ hasMultipleZeroes = true;}
        System.out.println(product);
        if(hasMultipleZeroes){
            output=new int[nums.length];
            return output;
        }
        if(hasZero){
            output=new int[nums.length];
            for (int j: zeros){
            output[j] = product;
        }}
        else{
        
        for(int i=0;i<nums.length; i++){
            if (nums[i]==0){output[i]=product;}
            else{ output[i]=(int) product/nums[i];
            System.out.println(output[i]);}
        }
        }
    
    return output;
    }
}  
