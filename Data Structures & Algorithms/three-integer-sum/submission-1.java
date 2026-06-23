class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sorting the array
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates for the first number
            }
            
            int j = i + 1; // Start of the second pointer
            int k = nums.length - 1; // Start of the third pointer
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    // Move the second pointer while skipping duplicates
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    
                    // Move the third pointer while skipping duplicates
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++; // We need a larger sum, move the second pointer to the right
                } else {
                    k--; // We need a smaller sum, move the third pointer to the left
                }
            }
        }
        return result;
    }
}
