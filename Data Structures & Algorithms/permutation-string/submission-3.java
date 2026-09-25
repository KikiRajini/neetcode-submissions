class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // 1. Build initial frequency maps for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // 2. Count initial matches across all 26 alphabet buckets
        //It is important to count initial matches because matches tracks relative changes, not absolute state. Step 3 only executes incremental adjustments (matches++ or matches--) whenever a character enters or leaves the window.
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                matches++;
            }
        }

        if (matches == 26) return true;

        // 3. Slide the fixed-size window across s2
        for (int right = n1; right < n2; right++) {
            int rightIdx = s2.charAt(right) - 'a';
            int leftIdx = s2.charAt(right - n1) - 'a';

            // --- Add incoming right character ---
            count2[rightIdx]++;
            if (count1[rightIdx] == count2[rightIdx]) {
                matches++; // Count just became equal
            } else if (count1[rightIdx] + 1 == count2[rightIdx]) {
                matches--; // Count was equal, but now overshot
            }

            // --- Remove outgoing left character ---
            count2[leftIdx]--;
            if (count1[leftIdx] == count2[leftIdx]) {
                matches++; // Count just became equal
            } else if (count1[leftIdx] - 1 == count2[leftIdx]) {
                matches--; // Count was equal, but now undershot
            }

            // If all 26 character frequencies match, we found a permutation!
            if (matches == 26) return true;
        }

        return false;
    }
}