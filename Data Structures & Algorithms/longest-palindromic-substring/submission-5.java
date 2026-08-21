class Solution {
    public String longestPalindrome(String s) {
        int start =0;
        int maxLength = 0;

        for(int i =0; i< s.length(); i++){
            int len1 = palindromeLength(s,i,i);
            int len2 = palindromeLength(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>maxLength){
                maxLength = len;
                start = i - (len-1)/2;
            }
        }

        return s.substring(start,start+maxLength);
        
    }

    private int palindromeLength(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--; right++;
        }
        return (right-1) - (left+1) +1;
    }
}
