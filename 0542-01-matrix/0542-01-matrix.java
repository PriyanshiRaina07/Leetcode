class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowL;
    static int colL;

    static class pair{
        int row;
        int col;

        public pair(int row, int col){
            this.row= row;
            this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        rowL = mat.length;
        colL = mat[0].length;

        boolean[][] visited = new boolean[rowL][colL];
         int[][] dist = new int[rowL][colL];
        
        Queue<pair> q = new LinkedList<>(); 
        for(int i = 0; i<rowL ; i++){
            for(int j = 0; j< colL; j++){
                 if( mat[i][j] == 0){
                    visited[i][j] = true;
                    q.offer(new pair(i,j));
                   
                }
            }
        }
        bfs(q, visited, dist, mat); 
        return dist;
        
    }
    public static void bfs( Queue<pair> q, boolean[][] visited,  int[][] dist,int[][]mat){
        

        while(!q.isEmpty()){
            pair curr = q.poll();
            int R = curr.row;
            int C = curr.col;
            for(int i = 0; i < 4; i++){
                int nRow = R + dr[i];
                int nCol = C +dc[i];
                
                if (nRow >= 0 && nCol >= 0 && nRow < rowL && nCol < colL &&
                    !visited[nRow][nCol]) {

                    visited[nRow][nCol] = true;
                    dist[nRow][nCol] = dist[R][C] + 1;
                    q.offer(new pair(nRow, nCol));
                }    
            }
        }
    }
}    