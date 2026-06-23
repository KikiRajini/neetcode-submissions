class Solution {
    public int characterReplacement(String s, int k) {
       int freq[] = new int[26];
       int left =0; int right =0;
       char arr[] = s.toCharArray();
       int maxLen=0;
     
       int max =-1;
       while(left<=right && right< s.length()){
            freq[arr[right]- 'A']++;
            max = Math.max(max, freq[arr[right] - 'A']);

            if((right-left+1 - max)>k){
                freq[arr[left]- 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen,right-left+1);
            right++;
       }
    return maxLen;

    }
}
