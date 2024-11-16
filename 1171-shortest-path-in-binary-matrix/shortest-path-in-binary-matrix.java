class Pair {

    int first;
    int second;
   // int distance;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
       // this.distance = distance;
    }

}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        int[] delrow={-1,0,1};
        int[] delcol={-1,0,1};
        
        if(n==1 && grid[0][0]==0) return 1;
        if(grid[0][0]==1) return -1;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        int dist[][] =new int[n][n];
        
        for(int[] row: dist){
            Arrays.fill(row,(int)1e9);
        }
        dist[0][0]=1;


        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            //int distance=q.peek().distance;
            q.remove();

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(!(delrow[i]==0 && delcol[j]==0)){
                         int nrow= row+delrow[i];
                         int ncol= col + delcol[j];

                        if(nrow>=0 &&nrow<n && ncol>=0 && ncol <n && grid[nrow][ncol]==0 ){
                                if(dist[row][col]+1<dist[nrow][ncol]){
                                    dist[nrow][ncol]=1+dist[row][col];
                                    q.add(new Pair(nrow,ncol));
                                }
                              
                        }

                    }
                   
                }
            }
            
        }

        if(dist[n-1][n-1]==(int)1e9){
            return -1;
        }

        return dist[n-1][n-1];

    }
}