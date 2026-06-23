class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set  = new HashSet<>();
        char arr[] = s.toCharArray();
        int left =0; int right =0; int max=0;

        while(left<=right && right<s.length()){
            if(!set.contains(arr[right])){
                set.add(arr[right]);
                max = Math.max(max, right-left+1);
                right++;
            }else{
                set.remove(arr[left]);
                left++;
            }
        }

        return max;
    }
}
