class Solution {
    public boolean isPalindrome(String s) {

        int length = s.length();
        int i=0; int j = length-1;
        char[] charList = s.toCharArray();

        while(i<j){
            System.out.println(charList[i]+"-" +charList[j]);
            if(!Character.isLetterOrDigit(charList[i])){i++;continue;}
            if(!Character.isLetterOrDigit(charList[j])){j--;continue;}
            if(Character.toLowerCase(charList[i])==Character.toLowerCase(charList[j])){
                i++; j--;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
