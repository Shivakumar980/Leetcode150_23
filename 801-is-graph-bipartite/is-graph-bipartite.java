class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;

        int[] colorArray= new int[n];
        Arrays.fill(colorArray,-1);

        for(int i=0; i< n ;i++){
            if(colorArray[i] == -1){
                if(!dfs(i,1, graph,colorArray)){
                     return false;
                }
            }
           
        }
        return true;
    }

    private boolean dfs(int node, int parentcolor, int[][] graph,int[] colorArray){
        colorArray[node]=parentcolor;
        for(int neighbor: graph[node]){
            if(colorArray[neighbor]==-1){
                if(!dfs(neighbor,1-colorArray[node],graph , colorArray)){
                    return false;
                }
            }
            else if(colorArray[neighbor]==parentcolor){
                return false;
            }
        }
        return true;

    }
}