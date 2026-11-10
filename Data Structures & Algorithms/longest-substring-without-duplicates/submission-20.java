class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> unique = new HashSet<>();
        int max =0;
        int length =0;
       int start =0; int end = 1;
       if(s.isEmpty()){return 0;}
       if(s.length() ==1 ){return 1;}
        unique.add(s.charAt(start));
        length++;
       while(end<s.length()){
        
            if(!unique.contains(s.charAt(end))){
                length++;
                unique.add(s.charAt(end));
            }else{
            while(unique.contains(s.charAt(end))){
                unique.remove(s.charAt(start));
                start++;
                length--;
                
            }
            length++;
                unique.add(s.charAt(end));
       
           
            }
                 max = Math.max(max,length);
            end++;
            
       }

       return max;
    }
}