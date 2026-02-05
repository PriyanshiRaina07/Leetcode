class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowL;
    static int colL;
    public int numEnclaves(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;

        boolean [][]visited = new boolean[rowL][colL];

        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j++){
                if((i == 0||j == 0||i == rowL - 1||j == colL - 1)&& grid[i][j] == 1){
                    dfs(i,j,visited,grid);
                }
            }

        }
        int count = 0;
        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j++){
                if(!visited[i][j]&& grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;

    }
    private void dfs(int r, int c, boolean[][]visited, int[][]grid){
        if(r < 0||c < 0|| r >= rowL|| c >= colL || grid[r][c] == 0) return;
        if(visited[r][c]) return;

         visited[r][c] = true;  // mark land as visited
 
        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i], visited, grid);
        }    
    }
}