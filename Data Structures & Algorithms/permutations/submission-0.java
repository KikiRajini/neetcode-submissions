class Solution {


    public List<List<Integer>> permute(int[] nums) {
 
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        generate(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void generate(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        // Base case: Full permutation completed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // Guard clause: skip already selected elements
            current.add(nums[i]);       // 1. Choose
            visited[i] = true;
            generate(nums, visited, current, result); // 2. Explore
            
            visited[i] = false;         // 3. Backtrack
            current.remove(current.size() - 1);
        }
    }

}
