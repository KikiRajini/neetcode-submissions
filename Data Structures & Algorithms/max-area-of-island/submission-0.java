class Solution {
    int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int r=0; r<row;r++){
            for(int c=0; c<col; c++){
                if(grid[r][c]==1){
                    maxArea = Math.max(maxArea,neutraliseForThisIsland(r,c,0,grid));

                }
            }
        }
        return maxArea;
    }

 private int neutraliseForThisIsland( int r, int c, int area,int[][] grid) {
    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
    grid[r][c]=0;
    area=1+
    neutraliseForThisIsland(r+1,c,area,grid)+
    neutraliseForThisIsland(r-1,c,area,grid)+
    neutraliseForThisIsland(r,c+1,area,grid)+
    neutraliseForThisIsland(r,c-1,area,grid);
    return area;
 }

}
