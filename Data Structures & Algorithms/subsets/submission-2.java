public class Solution {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        if (nums == null) return allSubsets;
        generate(0, nums, new ArrayList<>(), allSubsets);
        return allSubsets;
    }

    private void generate(int startIndex, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Snapshot current valid path  
       result.add(new ArrayList<>(current));
        for (int i = startIndex; i < nums.length; i++) {
            current.add(nums[i]);                     // 1. Choose
            generate(i + 1, nums, current, result);   // 2. Explore (i + 1 prevents backtracking duplicates)
            current.remove(current.size() - 1);       // 3. Backtrack
        }
    }


}