class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Target frequencies for string t
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // Window character frequencies
        Map<Character, Integer> window = new HashMap<>();

        int have = 0;
        int need = countT.size();

        // Track minimum window bounds: [length, leftIndex, rightIndex]
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Light turns GREEN for character 'c' when target frequency is met
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // Contract 'left' as long as current window is valid
            while (have == need) {
                // Update minimum result if smaller
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minLeft = left;
                    minRight = right;
                }

                // Remove character at 'left'
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // Light turns RED if frequency drops below target requirement
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }

                left++; // Shrink window
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}