class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowL; 
    static int colL;
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        Queue<int[]>q = new LinkedList<>();

        dist[0][0] = 0;
        q.offer(new int[]{0,0});


        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    int newCost = dist[r][c] + grid[nr][nc];

                   
                    if (newCost < dist[nr][nc]) {

                        dist[nr][nc] = newCost; //update kiya
                        q.offer(new int[]{nr, nc});   //then q add
                    }
                }
            }
        }

        return dist[m-1][n-1];   
        
    }
}