class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowL;
    static int colL;

    static class pair{
        int row;
        int col;

        public pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int shortestBridge(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;

        boolean[][] visited = new boolean[rowL][colL];
        Queue<pair> q = new LinkedList<>();

        boolean found = false;

        for(int i = 0; i < rowL; i++){
            if(found) break;
            for(int j = 0; j < colL; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, visited, grid, q);
                    found = true;
                    break;
                }
            }
        }

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                pair curr = q.poll();
                int R = curr.row;
                int C = curr.col;

                for(int i = 0; i < 4; i++){
                    int nRow = R + dr[i];
                    int nCol = C + dc[i];

                    if(nRow >= 0 && nCol >= 0 && nRow < rowL && nCol < colL &&
                        !visited[nRow][nCol]) {

                        visited[nRow][nCol] = true;

                        if(grid[nRow][nCol] == 1){
                            return level;
                        }

                        q.offer(new pair(nRow, nCol));
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] grid, Queue<pair> q){
        if(r < 0 || r >= rowL || c < 0 || c >= colL || visited[r][c] || grid[r][c] == 0)
            return;

        visited[r][c] = true;
        q.offer(new pair(r, c));

        for(int i = 0; i < 4; i++){
            dfs(r + dr[i], c + dc[i], visited, grid, q);
        }
    }
}
