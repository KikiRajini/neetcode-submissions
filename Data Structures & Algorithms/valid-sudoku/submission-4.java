class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> sq = new HashMap<>();
        
        for(int r =0; r<9 ; r++){
            for(int c=0; c<9; c++){
                if(board[r][c]!= '.'){
                    char val = board[r][c];
                    int sqVal = (r/3)*3+(c/3);
                
                    if(row.getOrDefault(r, new HashSet<>()).contains(val)||
                    col.getOrDefault(c, new HashSet<>()).contains(val)||
                    sq.getOrDefault(sqVal, new HashSet<>()).contains(val)){
                        return false;
                    }
                    row.computeIfAbsent(r, k -> new HashSet<>()).add(val);
                    col.computeIfAbsent(c, k -> new HashSet<>()).add(val);
                    sq.computeIfAbsent(sqVal, k -> new HashSet<>()).add(val);
                
            }}
        }
    return true;
    }
}
