class Solution {
    public boolean isPalindrome(String s) {
        int forward=0; int reverse=s.length()-1;
        char[] charArr = s.toCharArray();
        while(forward<reverse){
            if(!Character.isLetterOrDigit(charArr[forward])){forward++; continue;}
            if(!Character.isLetterOrDigit(charArr[reverse])){reverse--;continue;}
            if(Character.toUpperCase(charArr[forward])!=Character.toUpperCase(charArr[reverse])){
                return false;
            }
            forward++;
            reverse--;
        }
        return true;
    }
}
