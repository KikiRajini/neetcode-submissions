class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l =0;
        int matches =0;
        int[] trackers1  = new int[26];
        int[] trackers2  = new int[26];
        if(s2.length()<s1.length()) return false;
        for(int i = 0; i<s1.length(); i++){
            trackers1[s1.charAt(i)-'a']++;
            trackers2[s2.charAt(i)-'a']++;
        }

        for(int i =0; i<26; i++){
            if(trackers1[i] == trackers2[i]){matches++;}
        }

        if(matches==26){return true;}

        for(int r = s1.length(); r<s2.length(); r++){
           

            trackers2[s2.charAt(r) - 'a']++;
            if(trackers2[s2.charAt(r) - 'a'] == trackers1[s2.charAt(r) - 'a']){
                matches++;
            }else if(trackers2[s2.charAt(r) - 'a'] == trackers1[s2.charAt(r) - 'a'] +1){
                matches--;
            }

            trackers2[s2.charAt(l) - 'a']--;
            if(trackers2[s2.charAt(l) - 'a'] == trackers1[s2.charAt(l) - 'a']){
                matches++;
            }else if(trackers2[s2.charAt(l) - 'a'] +1 == trackers1[s2.charAt(l) - 'a']){
                matches--;
            }
            l++;

            if(matches==26) return true;
        }

        return false;
    }
}