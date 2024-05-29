class Solution {
    private int timer = 1;
    private void dfs(int node, int parent,List<List<Integer>> adj,int[] vis,int[] tin,int[] low,List<List<Integer>> bridges){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(Integer it:adj.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it,node,adj,vis,tin,low,bridges);
                low[node]=Math.min(low[node],low[it]);
            if(low[it]>tin[node]){
                bridges.add(Arrays.asList(it, node));
            }
        }
            else{
                low[node] = Math.min(low[node], low[it]);
            }

    }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new  ArrayList<Integer>());
        }
        for(List<Integer> connection:connections){
            int u=connection.get(0);
            int v=connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,adj,vis,tin,low,bridges);
        return bridges;

        
    }
}