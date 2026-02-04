// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         ArrayList<ArrayList<Integer>>adj = new ArrayList<>();


//         for(int i = 0; i < n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] edge:edges){
//             int u = edge[0];
//             int v = edge[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u); 
//         }
//         boolean[] visited = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();

//         q.add(source);
//         visited[source] = true;

//         while (!q.isEmpty()) {
//             int curr = q.poll();
//               if (curr == destination) return true;

//             for (int neighbour : adj.get(curr)) {
//                 if (!visited[neighbour]) {
//                     visited[neighbour] = true;
//                     q.add(neighbour);
//                 }
//             }
        
//         }
//         return false;
//     }

    

// }
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    private boolean dfs(int node, int dest,ArrayList<ArrayList<Integer>> adj,boolean[] visited) {

        if (node == dest) return true;   
        visited[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, dest, adj, visited)) {
                    return true; 
                }
            }
        }
        return false; 
    }    
}
