class Solution {

    private boolean dfs(int[][] graph, int node,int parentColor, int[] color) {
            color[node]=1-parentColor;
            for (int neighbour : graph[node]) {
                if (color[neighbour] == -1) {
                    if(!dfs(graph,neighbour,color[node],color)){
                        return false;
                    }
                } else if (color[node] == color[neighbour]) {
                    return false;
                }
            }
        
        return true;

    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, 1, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}