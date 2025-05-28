class Tuple{
    int first;
    int second;
    int time;

    public Tuple(int first, int second, int time){
        this.first=first;
        this.second=second;
        this.time= time;
    }
}
class Solution {
        int[] delrow={0,1,0,-1};
        int[] delcol={1,0,-1,0};
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        Queue<Tuple> q= new LinkedList<>();
        int[][] visited= new int[n][m];
        int freshOranges=0;
        for(int i=0; i<n ;i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==2){
                    q.add(new Tuple(i, j, 0));
                    visited[i][j]=1;
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }

        int t=0;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col= q.peek().second;
            int tm= q.peek().time;
            q.poll();

            t=Math.max(t,tm);

            for(int i=0 ; i< 4; i++){
                int nrow= row+delrow[i];
                int ncol= col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol< m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                      q.add(new Tuple(nrow, ncol, tm+1 ));

                    visited[nrow][ncol]=1;
                    freshOranges--;
                }
              
            }
        }
        if(freshOranges>0 ){
            return -1;
        }

        return t;


    }
}