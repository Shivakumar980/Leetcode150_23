class Solution {
    public int findCircleNum(int[][] isConnected) {

        List<List<Integer>> adj=new ArrayList<>();

        int n= isConnected.length;
        int m= isConnected[0].length;
        for( int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for( int i=0;i<n ;i++){
            for(int j=0;j<m ;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
             // Code here
        int nn = adj.size();
        int[] visited=new int[nn];
        int count=0;
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<nn;i++){
            if(visited[i]==0){
                dfs(visited,i,adj);
                count++;
            }
            
        }
        return count;
    }
     private void dfs(int[] visited, int node, List<List<Integer>>  adj){
        visited[node]=1;
        //ans.add(node);
        for(int element:adj.get(node)){
            if(visited[element]==0){
                dfs(visited, element, adj);
            }
        }
        return;
    }
    
}