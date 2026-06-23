class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> sq = new HashMap<>();
        
        for(int r =0; r<9 ; r++){
            for(int c=0; c<9; c++){
                if(board[r][c]!= '.'){
                Set<Character> rowSet;
                if(row.containsKey(r)){
                    rowSet = row.get(r);
                }else{
                    rowSet = new HashSet<>();
                }
                if(rowSet.contains(board[r][c])){
                return false;}
                else{rowSet.add(board[r][c]); row.put(r,rowSet);}
                
                Set<Character> colSet;
                if(col.containsKey(c)){
                    colSet = col.get(c);
                }else{
                    colSet = new HashSet<>();
                }
                if(colSet.contains(board[r][c])){System.out.println("col");
                System.out.println(board[r][c]); System.out.println(r);
                System.out.println(c);
                return false;}
                else{colSet.add(board[r][c]); col.put(c,colSet);}

                Set<Character> sqSet;
                int sqVal = (r/3)*3+(c/3);
                if(sq.containsKey(sqVal)){
                    sqSet = sq.get(sqVal);
                }else{
                    sqSet = new HashSet<>();
                }
                if(sqSet.contains(board[r][c])){return false;}
                else{sqSet.add(board[r][c]); sq.put(sqVal,sqSet);}


            }}
        }
    return true;
    }
}
