class Solution {
    static class pair{
        int r;
        int c;
        int time;
        public pair(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    static int []dr = {-1,1,0,0};
    static int []dc = {0,0,-1,1};
    static int rowL;
    static int colL;
    int maxTime = 0;
    public int orangesRotting(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;

        // boolean [][]visited = new boolean[rowL][colL];
        int fresh = 0; //no fresh available

        Queue<pair>q = new LinkedList<>();

        //add all rotten oranges into queue

        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j++){
                if(grid[i][j] == 2) {
                    q.offer(new pair(i,j,0)); //row.col.time
                   
                }
                else if (grid[i][j] == 1)  //KITNA FRESH HAI
                    fresh++;

            }
        }
        if(fresh == 0)
           return 0;      //no fresh orange in queue
        while(!q.isEmpty()){
            pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;
            int T = curr.time;

            maxTime = Math.max(maxTime,T);

            for(int i = 0; i < 4; i++){
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                //check valid and add into queue

                if(nRow >= 0 && nCol >= 0 && nRow < rowL && nCol < colL && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = 2;
                    fresh--;
                    q.offer(new pair(nRow,nCol,T+1));  
                }
            }

        }
            return (fresh == 0)?maxTime: -1;

    }
}