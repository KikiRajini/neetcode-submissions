class Solution {
    public boolean isValidSudoku(char[][] board) {
         Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> sq = new HashMap<>();

        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board.length; j++){
                char current = board[i][j];
                if (current == '.') continue;
                row.putIfAbsent(i, new HashSet<>());
                col.putIfAbsent(j, new HashSet<>());
                sq.putIfAbsent((i/3)*3+(j/3), new HashSet<>());
                
                if(row.get(i).contains(current) || col.get(j).contains(current) || sq.get((i/3)*3+(j/3)).contains(current)){
                    return false;
                }

                row.get(i).add(current);
                col.get(j).add(current);
                sq.get((i/3)*3+(j/3)).add(current);
            }
        }
        return true;
    }
}
