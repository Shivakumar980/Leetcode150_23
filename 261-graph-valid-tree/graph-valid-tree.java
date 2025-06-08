class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0 ; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] visited= new int[n];
        int count=0;
        for(int i=0; i< n ;i++){
            if(visited[i]==0){
                if(!dfs(adj, visited, i,-1)){
                    return false;
                }
                 count++;
            }
        }
        if(count>1 ) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] visited, int node, int parent){
        visited[node]=1;
        for( int neighbor: adj.get(node)){
            if(visited[neighbor]==0){
                if(!dfs(adj, visited, neighbor, node)){
                    return false;
                }
            }
            else if(neighbor!= parent){
                return false;
            }
        }
        return true;
    }
}