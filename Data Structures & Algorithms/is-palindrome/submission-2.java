class Solution {
    public boolean isPalindrome(String s) {
        int forward=0; int reverse=s.length()-1;

        while(forward<reverse){
            if(!Character.isLetterOrDigit(s.charAt(forward))){forward++; continue;}
            if(!Character.isLetterOrDigit(s.charAt(reverse))){reverse--;continue;}
            if(Character.toUpperCase(s.charAt(forward))!=Character.toUpperCase(s.charAt(reverse))){
                return false;
            }
            forward++;
            reverse--;
        }
        return true;
    }
}
