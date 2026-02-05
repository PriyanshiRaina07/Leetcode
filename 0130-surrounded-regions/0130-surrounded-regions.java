class Solution {
    static int[]dr = {-1,1,0,0};
    static int[]dc = {0,0,-1,1};
    static int rowL;           //in between then cover with X OR IF IN BOUNDRNDRY then 0
    static int colL;     //if 0 at boundry then call dfs and didnot cover but between gets cover
    public void solve(char[][] board) {
        rowL = board.length;
        colL = board[0].length;
        boolean [][]visited = new boolean[rowL][colL];

       for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if((i==0 || j==0 || i==rowL-1 || j==colL-1) && board[i][j]=='O' ){
                    dfs(i,j,visited,board);
                }
            }
        }
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int r,int c,boolean[][] visited,char[][] board){
        if(r<0 || r>=rowL || c<0 || c>=colL || board[r][c]=='X') return;
        if(visited[r][c])return;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],visited,board);
        }

    }
}