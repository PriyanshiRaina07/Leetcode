class Solution {
    static int[] parent;
    static int[] rank;

        public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        // Compare every pair of stones
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] ||stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        Set<Integer> components = new HashSet<>();
        for (int i = 0; i < n; i++) {
            components.add(find(i));
        }

        return n - components.size();


    }
}