class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left =0; 
        char arr[] = s.toCharArray();

        int maxLen =0;
        int max =0;

        for(int right =0; right<s.length(); right++){
            //increase freq of right char
            freq[arr[right]-'A']++;
            //find max length of a single char
            max = Math.max(max, freq[arr[right]-'A']);

            //if window length - max of single char is greater than toleratable k, remove char count for left and move left forward
            if((right-left+1 - max )> k){
                freq[arr[left]-'A']--;
                left++;
                //recompute max as it may have been that of the left char
                // max=0;
                // for(int i =0; i<26; i++){
                //     max = Math.max(max,freq[i]);
                // }
                //// max holds a historical peak: an outdated, higher value - it is tracking the all-time highest frequency needed to break your previous length record.
            }

            maxLen = Math.max(maxLen, right-left+1);
            

        }




        return maxLen;
    }
}
