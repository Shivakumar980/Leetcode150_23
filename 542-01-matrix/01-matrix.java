class Pair{
    int first;
    int second;
    int distance;
    public Pair(int first, int second , int distance){
        this.first=first;
        this.second=second;
        this.distance=distance;
    }
}
class Solution {
    int[] delrow = { 0, 1, -1, 0 };
    int[] delcol = { 1, 0, 0, -1 };

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[][] visited=new int[n][m];
        int[][] ans=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
            }
        }

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int distance=q.peek().distance;

            ans[row][col]=distance;
            q.poll();

         

            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && mat[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol, distance+1));
                    visited[nrow][ncol]=1;
                }
            }

        }
            

      return ans;      
    }
}