class Solution {
    List<Integer>[]tree;
    static int []distance;
    static int[] subTree;
    int[]ans;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        tree = new ArrayList[n];
        distance = new int[n];
        subTree = new int[n];
        ans = new int[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){ //list me add
            int a = edges[i][0];
            int b = edges[i][1];
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0,-1);
        ans[0] = distance[0];

        reRoot(0,-1); //root,parent

        return ans;


    }
    public void dfs(int node, int parent){   //ek node ka dfs call
        //initially 
        subTree[node] = 1;
        for(int child : tree[node]){
            if (child == parent) continue;
            dfs(child,node);
            subTree[node] += subTree[child];
            distance[node] += distance[child]+subTree[child];
        }
    }
    public void reRoot(int node, int parent){ //sbko parent bananao ek ek kar k
        for(int child : tree[node]){
            if(child == parent) continue;
            ans[child] = ans[node] +N - 2 * subTree[child];
            reRoot(child,node);
        }
    }
}