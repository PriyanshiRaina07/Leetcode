class Solution {
    static int[] parent;
    static int[] rank;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                provinces++;
            }
        }

        return provinces;
    }
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }


    static void union(int X, int Y){
        int rootX = find(X);
        int rootY = find(Y);

        if(rootX == rootY) return;
        
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } 
        else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } 
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

    }
}