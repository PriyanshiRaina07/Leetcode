class Solution {
    static int []dr = {-1,1,0,0};
    static int []dc = {0,0,-1,1};
    static int rowL;
    static int colL;
    public int numIslands(char[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        
        boolean [][]visited = new boolean[rowL][colL];
        int component = 0;

        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j ++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid,visited);
                    component++;
                }
            }
        }
        return component;
    }
    public void dfs(int r, int c, char[][]grid,boolean[][] visited){
        if(r < 0|| c < 0 || r >= rowL|| c >= colL|| grid[r][c] == '0' || visited[r][c]){
            return;
        }
        visited[r][c] = true;
      
        for(int i = 0; i < 4; i++){
            dfs(r + dr[i], c + dc[i], grid, visited);
        }
    }
}