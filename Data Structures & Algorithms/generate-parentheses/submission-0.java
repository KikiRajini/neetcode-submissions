class Solution {

        public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> charStack = new Stack<>();
        int open = 0; int close = 0;
        String s = "("; open++;

        generateCombo(s, open, close,result,n);


        return result;
    }
    
    private void generateCombo(String s, int open, int close,List<String> result, int n){


        if(open<n) {

                generateCombo(s+"(", open+1, close, result,n);

            }
        if (close<open && close<n) {

                generateCombo(s+")", open, close+1, result,n);

            }
        if(open==n && close ==n){
            result.add(s);
        }



    }
    
}
