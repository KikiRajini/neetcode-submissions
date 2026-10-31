class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(String str: strs){
        int size = str.length();
        sb.append(size);
        sb.append("#");
        sb.append(str);
       }

       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        while(end<str.length()){
        while(str.charAt(end) != '#'){end++;}
        int length = Integer.parseInt(str.substring(start,end));//2
        String word = str.substring(end+1,end+1+length);
        result.add(word);
        start = end+1+length;
        end = end+1+length;

        }

        return result;

       
    }
}
