class Solution {
   
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);//0,0,0,0
            List<List<Integer>> result = new ArrayList<>();
            int forward = 0;
            int reverse = nums.length-1;//3
            for(int n=0; n<nums.length;n++){
                forward= n+1;//1
                reverse = nums.length-1;//3
                if (n > 0 && nums[n] == nums[n - 1]) continue;
                while(reverse>forward){
                    if(nums[n]+nums[forward]+nums[reverse]==0){

                        result.add(Arrays.asList(nums[n],nums[forward],nums[reverse])); 
                        while(forward < reverse && nums[forward]==nums[forward+1]){forward++;}
                        while(forward < reverse && nums[reverse]==nums[reverse-1]){reverse--;}
                        reverse--; forward++;

                    }else if(nums[n]+nums[forward]+nums[reverse]>0){
                        reverse--; continue;
                    }else{
                        forward++; continue;
                    }


                }
            }
            return result;
        }
}
