class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSet, int[] nums, int start) {
        result.add(new ArrayList<>(currentSet));//[],[1],[1,2],[1,2,3]

        for(int i = start; i< nums.length; i++){
            //choose
            currentSet.add(nums[i]);//1
            //move forward
            backtrack(result,currentSet,nums, i+1);
            currentSet.remove(currentSet.size()-1);
        }
    }
}
