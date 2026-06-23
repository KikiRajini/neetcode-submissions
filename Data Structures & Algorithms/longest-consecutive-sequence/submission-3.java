class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int n : nums){numSet.add(n);}
//3,2,4,7
        int length =0;
        int longest=0;
         for(int n : numSet){
            if(!numSet.contains(n-1)){
                length =1;
                while(numSet.contains(n+length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
         }
return longest;
    }
}
