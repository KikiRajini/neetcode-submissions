
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> finalList = new ArrayList<>();
       List<String> anagramList = new ArrayList<>();
        for (int i=0; i<strs.length;i++){
            String a = strs[i];
            if (!anagramList.contains(a)){
            List<String> temp = new ArrayList<>();
            temp.add(a);
            anagramList.add(a);
            for (int j=i+1; j<strs.length;j++){
                String b = strs[j];
                if(isAnagram(a,b)){
                    
                    temp.add(b);
                    anagramList.add(b);
                }
            }
            finalList.add(temp);
        }}
        System.out.println(finalList);
        return finalList;
    }

    public boolean isAnagram(String a, String b){
        if (a.length() != b.length()){return false;}
        int[] alphaCount = new int[26];
        for (int i=0; i< a.length(); i++){
            alphaCount[a.charAt(i)-'a']++;
            alphaCount[b.charAt(i)-'a']--;
        }
        int[] dummy = new int[26];
        if (Arrays.equals(alphaCount, dummy)){return true;}
        else {return false;}
    }
}
