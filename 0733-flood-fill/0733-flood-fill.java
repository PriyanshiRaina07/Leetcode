class Solution {
    static int[] sr = {-1,1,0,0};
    static int[] sc = {0,0,-1,1};
    static int rowL;
    static int colL;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rowL = image.length;
        colL = image[0].length;

        boolean[][] visited = new boolean[rowL][colL];
         int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        dfs(sr, sc, image, visited, originalColor, color);

        return image;
         
    }
     public void dfs(int r, int c, int[][] image, boolean[][] visited,int originalColor, int newColor) {
         if (r < 0 || c < 0 || r >= rowL || c >= colL ||
            visited[r][c] || image[r][c] != originalColor) {
            return;
        }

        visited[r][c] = true;
        image[r][c] = newColor;

        for (int i = 0; i < 4; i++) {
            dfs(r + sr[i], c + sc[i], image, visited, originalColor, newColor);
        }
     }
}