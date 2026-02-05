class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowL;
    static int colL;
    public int islandPerimeter(int[][] grid) {

        rowL = grid.length;
        colL = grid[0].length;

        boolean[][] visited = new boolean[rowL][colL];

        for(int i = 0; i < rowL; i ++){
            for(int j = 0; j <colL; j++){
                if(grid[i][j] == 1){
                    return dfs(i,j,grid,visited);
                }

            }
        }
        return 0;

    }
    private int dfs(int r, int c,  int[][]grid,boolean[][]visited){
        if(r < 0|| c < 0|| r >= rowL|| c >= colL ){
            return 1;          //boundry touch so 0
        }
        if (grid[r][c] == 0) {
            return 1;                  // Water contributes +1 perimeter
        }

        if (visited[r][c]) {             //already visited return 0
            return 0;
        }

        visited[r][c] = true;

        int perimeter = 0;

        for (int i = 0; i < 4; i++) {
            perimeter += dfs(r + dr[i], c + dc[i], grid, visited);
        }

        return perimeter;
    }
}