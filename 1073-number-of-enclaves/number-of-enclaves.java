class Solution {
    int[] delrow = { 0, 1, -1, 0 };
    int[] delcol = { 1, 0, 0, -1 };
    public int numEnclaves(int[][] grid) {
        return solve(grid);
    }

    public int solve(int[][] board) {
        int n=board.length;
        int m=board[0].length;

        int[][] visited=new int[n][m];

        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m ;j++){
                if( 
                    visited[i][j]==0 && board[i][j]==1 &&
                 ((i==0 && j<m)|| (i==n-1 && j<m) || (j==0 && i<n) || (j==m-1 && i<n))
                 ){
                    dfs(i,j,visited,board);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m ;j++){
                if( visited[i][j]==0 && board[i][j]==1){
                    count++;;
                }
            }
        }
        return count;
    }

    private void dfs(int row,int col, int[][] visited,int[][] board){
        int n=board.length;
        int m=board[0].length;
            visited[row][col]=1;

            for(int i=0;i<4;i++){
                int nrow= row +delrow[i];
                int ncol= col+ delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]==1 ){
                    dfs(nrow,ncol,visited,board);
                }
            }
    }
}