class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left=0; int right=0;
        int ref[] = new int[26];
        int count =0;
        for(int i =0; i<s1.length(); i++){
            ref[s1.charAt(i)-'a']++;
        }
        int windowLength = s1.length();
        int com[] = new int[26];
        while(left<=right  && right<s2.length() ){

           if(count <=windowLength){
            com[s2.charAt(right) - 'a']++;
            count++; right++;
           }
           if(count == windowLength){
            if(Arrays.equals(ref,com)){
            return true;
                }else{
            com[s2.charAt(left) - 'a']--;
            left++;
            count--;
           }
           }
        }
        return false;
    }
}
