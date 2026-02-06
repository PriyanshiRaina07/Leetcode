 class Solution {
    static int []dr = {-1,1,0,0};
    static int []dc = {0,0,-1,1};
    static int rowL;
    static int colL;
    static char []direction = {'U','D','L','R'};
    static class pair{
        int row;
        int col;
        public pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        
        boolean [][]visited = new boolean[rowL][colL];
        int component = 0;
        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(i,j,visited,grid);
                    component++;
                }    
            }
        }
        return component;
    }
    public void bfs(int r, int c, boolean[][] visited, char[][]grid){
        Queue<pair>q = new LinkedList<>();

        visited[r][c] = true;
        q.offer(new pair(r,c));

        while(!q.isEmpty()){
            pair curr = q.poll();
            int R = curr.row;
            int C = curr.col;
            for(int i = 0; i < 4; i++){
                int nRow = R + dr[i];
                int nCol = C +dc[i];
                if(nRow >= 0 && nCol >= 0 && nRow < rowL && nCol < colL && !visited[nRow][nCol] && grid[nRow][nCol] =='1'){
                    visited[nRow][nCol] = true;
                    q.offer(new pair(nRow,nCol));
                }
            }
        }
    }
}  
       
   
