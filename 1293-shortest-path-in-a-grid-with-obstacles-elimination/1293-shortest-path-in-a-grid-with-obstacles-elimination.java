class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowL;
    static int colL;
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        boolean[][][] visited = new boolean[m][n][k+1];

        Queue<int[]>q = new LinkedList<>();

        q.offer(new int[]{0,0,k,0});
        visited[0][0][k] = true;
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int remK = curr[2];
            int steps = curr[3];
            if (r == m - 1 && c == n - 1) {
                return steps;
            }
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int newK = remK - grid[nr][nc];
                    if (newK >= 0 && !visited[nr][nc][newK]) {
                        visited[nr][nc][newK] = true;
                        q.offer(new int[]{nr, nc, newK, steps + 1});
                    
                    }    
                }
            }    

        } 
        return -1;
    }       
  
}