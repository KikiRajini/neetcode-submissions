

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();
        
        // Edge case safety guard
        if (digits == null || digits.length() == 0) {
            return result;
        }

        checkCombination(0, digits, mapping, new StringBuilder(), result);
        return result;
    }

    private void checkCombination(int index, String digits, String[] mapping, StringBuilder current, List<String> result) {
        // Fix 1: Added return; to stop the function once a combination is finished
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return; 
        }

        char digitChar = digits.charAt(index);
        int digitNum = digitChar - '0'; 
        String letters = mapping[digitNum]; 
        
        for (int i = 0; i < letters.length(); i++) {
            // Fix 2: Changed to standard StringBuilder syntax methods
            current.append(letters.charAt(i));
            
            // Fix 3: Changed i + 1 to index + 1 to step to the next digit correctly
            checkCombination(index + 1, digits, mapping, current, result);
            
            // Fix 4: Changed to standard StringBuilder delete syntax
            current.deleteCharAt(current.length() - 1);
        }
    }
}