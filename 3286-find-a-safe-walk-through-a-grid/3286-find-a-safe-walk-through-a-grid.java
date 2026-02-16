class Solution {
    static class Pair {
        int row;
        int col;
        int cost;

        Pair(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        int startCost = grid.get(0).get(0);
        dist[0][0] = startCost;

        pq.add(new Pair(0, 0, startCost));

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int r = curr.row;
            int c = curr.col;
            int cost = curr.cost;

            if (r == m - 1 && c == n - 1) {
                return cost < health;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {

                    int newCost = cost + grid.get(nr).get(nc);

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new Pair(nr, nc, newCost));
                    }
                }
            }
        }

        return false;
    }
}