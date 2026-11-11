class Solution {
    public int characterReplacement(String s, int k) {
       int l =0;
       int maxLength = 0;
       int maxFreq = 0;
       int[] tracker = new int[26];

       for(int r=0; r<s.length(); r++){
            tracker[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,tracker[s.charAt(r)-'A']);
            if(maxFreq + k < r-l+1){
                tracker[s.charAt(l)-'A']--;
                l++;
            }


            maxLength = Math.max(maxLength,r-l+1);
       }
       return maxLength;
    }
}