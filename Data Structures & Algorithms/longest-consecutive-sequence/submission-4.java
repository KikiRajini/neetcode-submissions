class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int n :nums){
            uniqueNums.add(n);
        }
        int longest =0;
        int length =0;
        for (int n :nums){
            if(!uniqueNums.contains(n-1)){
                length=1;
                while(uniqueNums.contains(n+length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }

        }
        return longest;
    }
}
