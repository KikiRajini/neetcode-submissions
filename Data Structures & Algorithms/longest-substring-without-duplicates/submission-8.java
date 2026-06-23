class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        char[] charArr = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int max = 0;

        for (int r = 0; r < charArr.length; r++) {
            // If we find a duplicate, shrink the window from the left
            while (charSet.contains(charArr[r])) {
                charSet.remove(charArr[l]);
                l++;
            }
            
            // Add the current character and update max
            charSet.add(charArr[r]);
            max = Math.max(max, r - l + 1);
        }
        
        return max;
    }
}