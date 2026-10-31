class Solution {
    public boolean isValidSudoku(char[][] board) {
       Set<Character>[] rows = new HashSet[9];
       Set<Character>[] cols = new HashSet[9];
       Set<Character>[] sqs = new HashSet[9];

       for(int i =0; i<9; i++){
        rows[i] = new HashSet<>();
        cols[i] = new HashSet<>();
        sqs[i] = new HashSet<>();
       }

       for(int r =0; r<9; r++){
        for(int c=0; c<9; c++){
            char curr = board[r][c];
            if(curr=='.') continue;

            int s = r/3*3 + c/3;

            if(rows[r].contains(curr) || cols[c].contains(curr) || sqs[s].contains(curr)){
                return false;
            }
            rows[r].add(curr);
            cols[c].add(curr);
            sqs[s].add(curr);
        }
       }

       return true;

        
    }
}
