class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        //make reverse graph as we will know who depende

        List<List<Integer>> rev = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            rev.add(new ArrayList<>());
        }

        int[] outdegree = new int[n]; //outdegree array

        for(int i = 0; i < n; i++){
            outdegree[i] = graph[i].length;
            for(int neighbour : graph[i]){
                rev.get(neighbour).add(i);
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(outdegree[i] == 0){
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[n];

        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;

            for(int parent : rev.get(node)){
                outdegree[parent]--;
                if(outdegree[parent ] == 0){
                    q.offer(parent);    //q me add kr do
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(safe[i]) result.add(i);
        }
        return result;
    }
}