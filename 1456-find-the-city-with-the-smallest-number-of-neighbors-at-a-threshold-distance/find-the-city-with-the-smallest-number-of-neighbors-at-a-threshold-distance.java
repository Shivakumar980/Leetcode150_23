class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] matrix= new int[n][n];
        for(int[] row:matrix){
             Arrays.fill(row,-1);
       
        }
        
        int m=edges.length;

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            matrix[u][v]= wt;
            matrix[v][u]= wt;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=(int)1e8;
                }
                if(i==j){
                    matrix[i][j]=0;
                }
             }
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min( matrix[i][j],
                    matrix[i][via]+matrix[via][j]
                    );
                }
            }
        }

        int node=-1;
        //int count=Integer.MAX_VALUE;
        int mincount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                    if(matrix[i][j]!=0 && matrix[i][j]<=distanceThreshold){
                count++;
                }
            }
            if(count<=mincount){
                mincount=count;
                node=i;
            }
        }
            
        return node;
    }
}