class Solution {
    public boolean isAnagram(String s, String t) {
        int[] trace = new int[26];
        if(s.length()!=t.length()){return false;}
        for(int i =0; i<s.length();i++){
            trace[s.charAt(i)-'a']++;
            trace[t.charAt(i)-'a']--;
        }
        for(int n:trace){
           if( n!=0) return false;
        }
        return true;
    }
}
