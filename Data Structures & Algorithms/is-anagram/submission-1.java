class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
    
        String[] arr_S = s.split("");
        String[] arr_T = t.split("");
        Map<String, Integer> og = new HashMap<>();
        Map<String, Integer> dupe = new HashMap<>();
        for (int i=0; i< arr_S.length; i++ ){
           if (og.containsKey(arr_S[i])){
            og.put(arr_S[i],og.get(arr_S[i])+1);
           } else{
            og.put(arr_S[i],1);
           }
           if (dupe.containsKey(arr_T[i])){
            dupe.put(arr_T[i],dupe.get(arr_T[i])+1);
           } else{
            dupe.put(arr_T[i],1);
           }


    }
    System.out.println(og);
    System.out.println(dupe);
    if (og.equals(dupe)){
        return true;
    }
    else { return false;}
}
}
