class Solution {
    static int[]dr = {-1,1,0,0};
    static int[]dc = {0,0,-1,1};
    static int rowL;
    static int colL; 
    public int maxAreaOfIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;

        boolean[][] visited = new boolean[rowL][colL];
        int maxArea = 0;

        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j++){
                 if (!visited[i][j] && grid[i][j] == 1) {
                    int currentArea = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;  
    }
    private int dfs(int r, int c, int[][]grid, boolean[][]visited){
        if(r < 0|| c < 0|| r >= rowL || c >= colL ||  grid[r][c] == 0 || visited[r][c]){
            return 0;
        }
         visited[r][c] = true;

        int area = 1; // count current cell
        for (int i = 0; i < 4; i++) {
            area += dfs(r + dr[i], c + dc[i], grid, visited);
        }

        return area;
    }
}