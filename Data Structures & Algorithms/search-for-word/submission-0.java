class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r =0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(search(board,r,c,word,0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board,int r, int c, String word, int index){
        //becuase index in incremented before a recursive call
        if(index == word.length()){return true;}
        if(r <0 || c <0 || r >= board.length|| c >= board[0].length || board[r][c]!=word.charAt(index)){return false;}
        char curr = board[r][c];
        board[r][c] ='#';
        boolean exists = search(board,r+1,c,word,index+1)||
        search(board,r-1,c,word,index+1)||search(board,r,c+1,word,index+1)||
        search(board,r,c-1,word,index+1);
        board[r][c] = curr;

        return exists;
    }

}
