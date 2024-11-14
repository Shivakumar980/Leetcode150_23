class Solution {
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        //int m=graph[0].length;
        color=new int[n];
        Arrays.fill(color,-1);
    
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,1,graph)==false){
                    return false;
                }
            }
           
        }
        return true;
    }
    private boolean dfs(int node, int parentColor,int[][] graph){

            color[node]=1-parentColor;
    
            
            for(int element:graph[node]){
                if(color[element]!=-1 && color[element]==color[node]){
                    return false;
                }
                else if(color[element]==-1 ){
                     if(dfs(element,color[node],graph)==false){
                        return false;
                     }
                }  
            }

            return true;

    }
}