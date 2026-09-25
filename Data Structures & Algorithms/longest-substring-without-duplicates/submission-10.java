class Solution {
    public int lengthOfLongestSubstring(String s) {
    char[] charArr = s.toCharArray();
    Set<Character> set = new HashSet<>();
    int l =0;
    int max=0;

    for(int r=0; r<charArr.length; r++){

        while(set.contains(charArr[r])){
            set.remove(charArr[l]);
            l++;
        }
        set.add(charArr[r]);
        max = Math.max(max, r-l+1);
    }
    

    return max;
    }
}