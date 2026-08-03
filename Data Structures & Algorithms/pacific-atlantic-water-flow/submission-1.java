class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c = 0 ; c < heights[0].length ; c++){
            dfs(heights, 0 , c ,  heights[0][c], pacific);
            dfs(heights, rows-1 , c ,  heights[rows-1][c], atlantic);
        }

        for(int r = 0 ; r < heights.length ; r++){
            dfs(heights, r , 0 ,  heights[r][0], pacific);
            dfs(heights, r , cols-1 ,  heights[r][cols-1], atlantic);
        }

        for(int r = 0 ; r < heights.length ; r++){
            for(int c = 0 ; c < heights[0].length ; c++){
                if(pacific[r][c]&&atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
            }

            return result;

    }

    private void dfs (int[][] heights, int r, int c, int prevHeight, boolean[][] visited){
        if(r >= heights.length || c >= heights[0].length || r < 0 || c < 0 || visited[r][c] || heights[r][c] < prevHeight){
            return;
        }
        visited[r][c] = true;
        dfs(heights, r + 1,  c,  heights[r][c], visited);
        dfs(heights, r - 1,  c,  heights[r][c], visited);
        dfs(heights, r , c + 1,  heights[r][c], visited);
        dfs(heights, r , c - 1,  heights[r][c], visited);
    }
}
