class Solution {

    private boolean bfs(int[][] graph, int start, int[] color) {
        // int V = graph.length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (int neighbour : graph[node]) {
                if (color[neighbour] == -1) {
                    q.add(neighbour);
                    color[neighbour] = 1 - color[node];
                } else if (color[node] == color[neighbour]) {
                    return false;
                }
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
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}