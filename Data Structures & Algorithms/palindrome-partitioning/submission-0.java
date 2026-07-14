class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int index, List<String> current, List<List<String>> result){
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                partition(s, i + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while (right > left) {
            if (s.charAt(right) != s.charAt(left)) {
                return false;
            }
            right--; 
            left++;
        }
        return true;
    }
}