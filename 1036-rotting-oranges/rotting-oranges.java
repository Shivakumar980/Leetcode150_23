class Pair{
    int row;
    int col;
    int time;
    public Pair(int row, int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int maxTime=0;
        int n=grid.length;
        int m=grid[0].length;
        int countFresh=0;
        int count=0;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};
        
        for( int i=0;i<n;i++){
            for(int j=0;j<m ;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                 else if(grid[i][j]==1){
                    countFresh++;
                }  
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            maxTime=Math.max(time,maxTime);
            q.remove();
           
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow< n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,time+1));
                    vis[nrow][ncol]=1;
                    count++;
                }
            }

        }
        if(countFresh!=count) return -1;
       return maxTime; 
    }
}