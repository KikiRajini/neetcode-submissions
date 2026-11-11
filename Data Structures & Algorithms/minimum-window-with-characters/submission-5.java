class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] need = new int[58]; // covers 'A'-'Z' and 'a'-'z' with offset 'A'
        int[] trackerT = new int[58];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i) - 'A']++;
        }

        int left = 0;
        int l = 0, r = 0;
        int minLength = Integer.MAX_VALUE;
        int matches = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            int rightIdx = rightChar - 'A';
            
            trackerT[rightIdx]++;
            
            // Only increment matches if we haven't exceeded the required count for this char
            if (trackerT[rightIdx] <= need[rightIdx]) {
                matches++;
            }

            // Once we have matched all characters of t, try to shrink from the left
            while (matches == t.length()) {
                if (right - left + 1 < minLength) {
                    l = left; 
                    r = right;
                    minLength = r - l + 1;
                }

                char leftChar = s.charAt(left);
                int leftIdx = leftChar - 'A';
                
                trackerT[leftIdx]--;
                
                // If dropping this character drops us below the needed amount, reduce matches
                if (trackerT[leftIdx] < need[leftIdx]) {
                    matches--;
                }
                left++;
            }
        }

        // Return empty string if no valid window was found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(l, r + 1);
    }
}