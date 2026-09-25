class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        char[] arr = s.toCharArray();

        for (int right = 0; right < s.length(); right++) {
            freq[arr[right] - 'A']++;
            // max holds a historical peak needed to break your previous record
            max = Math.max(max, freq[arr[right] - 'A']);

            // If invalid, shift the window forward (window size stays fixed)
            if ((right - left + 1 - max) > k) {
                freq[arr[left] - 'A']--;
                left++;
            }
        }

        // The maximum valid window size is the final window length
        return s.length() - left;
    }
}