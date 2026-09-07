

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append length, then '#', then the string itself
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // Find the next '#' delimiter starting from our current position 'i'
            int delimiterPos = str.indexOf('#', i);
            
            // Read the length of the string
            int size = Integer.parseInt(str.substring(i, delimiterPos));
            
            // The string starts exactly after the '#'
            int start = delimiterPos + 1;
            int end = start + size;
            
            // Extract the string and add to result
            result.add(str.substring(start, end));
            
            // Move 'i' to the start of the next encoded string
            i = end;
        }
        
        return result;
    }
}