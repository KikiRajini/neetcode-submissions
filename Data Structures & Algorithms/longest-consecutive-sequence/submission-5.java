class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> unique = new HashSet<>();

       for(int n: nums){
        unique.add(n);
       }

        int longest = 0;
        int length = 0;

        for(int n :  nums){
            if(!unique.contains(n-1)){
                length = 1;
                while(unique.contains(n+length)){
                    length++;
                }

                longest = Math.max(longest,length);
            }

        }

        return longest;
    }
}
