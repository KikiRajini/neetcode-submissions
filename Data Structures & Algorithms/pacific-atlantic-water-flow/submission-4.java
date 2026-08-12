class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean atlantic[][] = new boolean[rows][cols];
        boolean pacific[][] = new boolean[rows][cols];

        for(int c = 0; c<cols; c++){
            dfs(0,c,heights,heights[0][c],pacific);
            dfs(rows-1,c,heights,heights[rows-1][c],atlantic);
        }

        for(int r = 0; r<rows; r++){
            dfs(r,0,heights,heights[r][0],pacific);
            dfs(r,cols-1,heights,heights[r][cols-1],atlantic);
        }
for(int r = 0; r<rows; r++){
        for(int c = 0; c<cols; c++){
            
                if(pacific[r][c]&&atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;

    }


    public void dfs(int r, int c, int[][]heights, int prevHeight, boolean[][] visited){
        if(r>=heights.length || c>=heights[0].length || r<0 || c<0 || visited[r][c] || heights[r][c]<prevHeight){return;}

        visited[r][c]=true;
        dfs(r+1,c,heights,heights[r][c],visited);
        dfs(r,c+1,heights,heights[r][c],visited);
        dfs(r-1,c,heights,heights[r][c],visited);
        dfs(r,c-1,heights,heights[r][c],visited);
    }
}
