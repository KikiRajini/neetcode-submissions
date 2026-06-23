class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> sqMap = new HashMap<>();

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c]=='.'){continue;}
                if(rowMap.getOrDefault(r, new HashSet<Character>()).contains(board[r][c]) ||
                colMap.getOrDefault(c, new HashSet<Character>()).contains(board[r][c]) ||
                sqMap.getOrDefault(((r/3)*3 + c/3), new HashSet<Character>()).contains(board[r][c])){
                    return false;
                }else{
                    rowMap.putIfAbsent(r, new HashSet<Character>());rowMap.get(r).add(board[r][c]);
                    colMap.putIfAbsent(c, new HashSet<Character>());colMap.get(c).add(board[r][c]);
                    sqMap.putIfAbsent(((r/3)*3 + c/3), new HashSet<Character>());sqMap.get((r/3)*3 + c/3).add(board[r][c]);
                }  
            }
          
        }return true;
    }  
    
}
   

