class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i ++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int neighbour : adj.get(i)) 
                indegree[neighbour]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int courses = q.poll();
             order[idx++] = courses;

            for (int nei : adj.get(courses)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        //  valid order
        if (idx == numCourses) return order;

        //  graph has cycle → no valid order
        return new int[0];
            
        
        
        
    }
}