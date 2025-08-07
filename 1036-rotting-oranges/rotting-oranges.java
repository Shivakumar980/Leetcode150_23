class Tuple{
    int first;
    int second;
    int time;

    public Tuple(int first, int second, int time){
        this.first= first;
        this.second= second;
        this.time= time;
    }
}

class Solution {
    int[] delrow={-1,0,1,0};
    int[] delcol={0,-1,0,1};
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        Queue< Tuple> q= new LinkedList<>();
        int freshOranges=0;
        for(int i=0 ; i<n ;i++){
            for(int j=0 ; j< m ; j++){
                if(grid[i][j]==2){
                    q.offer(new Tuple(i, j, 0));
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }

        int tm=0;
        while(!q.isEmpty()){
            Tuple tp= q.poll();

            int row= tp.first;
            int col= tp.second;
            int time= tp.time;

            tm=Math.max(time, tm);

            for(int i=0 ; i< 4 ;i++){
                int  nrow= row+delrow[i];
                int  ncol= col+delcol[i];
                if(nrow>=0 && nrow < n && ncol>= 0 && ncol <m && grid[nrow][ncol]== 1){
                    grid[nrow][ncol]=2;

                   // if there are fresh oranges , we have to return -1;
                   freshOranges--;
                    q.offer(new Tuple(nrow, ncol, time+1));
                }
            }


        }
        if(freshOranges>0) return -1;

        return tm;
    }
}