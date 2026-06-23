class Solution {

           public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs){
                if(s.length()<10) {
                    sb.append("00" + s.length());
                }else if(s.length() <100){
                    sb.append("0" + s.length());
                }else{
                    sb.append(s.length());
                }
                sb.append(s);
            }
            return sb.toString();
        }

        public List<String> decode(String str) {
            int start = 0;
            int end = 0;
            int length =0;
            StringBuilder sb = new StringBuilder(str);
            List<String> result = new ArrayList<>();
            while(start<str.length()){

                length = Integer.parseInt(sb.substring(start,start+3));
                end = length+start+3;
                result.add(sb.substring(start+3,end));
                start = end;

            }
            return result;

        }
}

