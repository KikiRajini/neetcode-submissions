class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] trace = new int[128]; // ASCII range

        for (int i = 0; i < s.length(); i++) {
            trace[s.charAt(i)]++;
            trace[t.charAt(i)]--;
        }

        for (int n : trace) {
            if (n != 0) return false;
        }
        return true;
    }
}