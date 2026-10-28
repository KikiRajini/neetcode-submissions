class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] sq = new HashSet[9];

        for(int i =0; i <9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            sq[i] = new HashSet<>();
        }


    for(int r =0; r<9; r++){
        for(int c =0; c<9; c++){
            Character value = board[r][c];
            if(value =='.'){continue;}
            int box = (r/3)*3 + c/3;
            if(rows[r].contains(value) || cols[c].contains(value) || sq[box].contains(value)){
                return false;
            }
            else {
                rows[r].add(value);
                cols[c].add(value);
                sq[box].add(value);

            }
        }
    }
   return true;
    }
}
