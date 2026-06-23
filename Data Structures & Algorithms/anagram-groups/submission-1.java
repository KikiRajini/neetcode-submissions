class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();
        List<List<String>> finalResult = new ArrayList<>();
        for( int i =0; i< strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(result.containsKey(sortedStr)){
                result.get(sortedStr).add(strs[i]);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                result.put(sortedStr, temp);
            }
        }

        for (String key : result.keySet()) {
            finalResult.add(result.get(key));
        }
        return finalResult;
    }
}
