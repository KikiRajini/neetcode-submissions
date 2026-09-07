class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedSB = new StringBuilder();
        for(String str: strs){
            encodedSB.append(str.length()).append("#").append(str);
        }
        return encodedSB.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int index = 0;
        while(index<str.length()){
        int numIndex = index;
        while(str.charAt(numIndex)!='#'){
            numIndex++;
        }
        int len = Integer.parseInt(str.substring(index, numIndex));
        String word = str.substring(numIndex+1, numIndex+1+len);
        decodedStrs.add(word);

        index = numIndex + 1 + len;
    }
    return decodedStrs;

    }
}
