class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
       List<String> decoded = new ArrayList<>();
       int index =0 ;
        while(index<str.length()){
            int numIndex = index;
            while(str.charAt(numIndex)!='#'){numIndex++;}
            int len = Integer.parseInt(str.substring(index,numIndex));
            //numIndex not included.
            String word = str.substring(numIndex+1, numIndex+1+len);
            // numIndex+1+len not included
            decoded.add(word);

            index = numIndex+1+len;

        }



       return decoded;

    }
}
