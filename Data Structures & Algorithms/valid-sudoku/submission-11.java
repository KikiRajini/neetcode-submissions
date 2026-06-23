class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<Integer,Set<Character>> boxes = new HashMap<>();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(board[row][col]=='.'){continue;}
                rows.putIfAbsent(row,new HashSet<>());
                if(rows.get(row).contains(board[row][col])){
                    return false;
                }else{
                    rows.get(row).add(board[row][col]);
                }

                cols.putIfAbsent(col,new HashSet<>());
                if(cols.get(col).contains(board[row][col])){
                    return false;
                }else{
                    cols.get(col).add(board[row][col]);
                }

                int boxnum = (row/3)*3 + (col/3);
                boxes.putIfAbsent(boxnum,new HashSet<>());
                if(boxes.get(boxnum).contains(board[row][col])){
                    return false;
                }else{
                    boxes.get(boxnum).add(board[row][col]);
                }


            }
        }
        return true;
    }
}
