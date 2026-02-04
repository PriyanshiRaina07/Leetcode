class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();


        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
              if (curr == destination) return true;

            for (int neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        
        }
        return false;
    }
}