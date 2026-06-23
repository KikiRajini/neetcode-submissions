class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // initialize sets ONCE
        for(int i=0;i<9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){

                if(board[row][col]=='.') continue;

                char val = board[row][col];
                int boxnum = (row/3)*3 + (col/3);

                if(rows[row].contains(val) ||
                   cols[col].contains(val) ||
                   boxes[boxnum].contains(val)){
                    return false;
                }

                rows[row].add(val);
                cols[col].add(val);
                boxes[boxnum].add(val);
            }
        }
        return true;
    }
}
