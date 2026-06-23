class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){return 0;}
        
        int length=1;
        int left =0; int right=0;
        Set<Character> c = new HashSet<>();

        while( right< s.length()){
            if(!c.contains(s.charAt(right))){
                c.add(s.charAt(right));
                right++;
            }else{
                while(c.contains(s.charAt(right))){
                    c.remove(s.charAt(left)); left++;
                }
            }
            length = Math.max(length, right-left);
            }
            return length;
        }
    
}
