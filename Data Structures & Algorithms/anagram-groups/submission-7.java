class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> tracker = new HashMap<>();
        for(String s: strs){
            int count[] = new int[26];
            for(int i =0 ; i< s.length(); i++){
                count[s.charAt(i)-'a']++;
            }
            String countStr = Arrays.toString(count);
            tracker.putIfAbsent(countStr,new ArrayList<>());
            tracker.get(countStr).add(s);
        }

        return new ArrayList<>(tracker.values());
    }
}
