class Solution {
    int[] delrow = { 0, 1, -1, 0 };
    int[] delcol = { 1, 0, 0, -1 };
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        int[][] visited=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m ;j++){
                if( 
                    visited[i][j]==0 && board[i][j]=='O' &&
                 ((i==0 && j<m)|| (i==n-1 && j<m) || (j==0 && i<n) || (j==m-1 && i<n))
                 ){
                    dfs(i,j,visited,board);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m ;j++){
                if( visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        
    }

    private void dfs(int row,int col, int[][] visited,char[][] board){
        int n=board.length;
        int m=board[0].length;
            visited[row][col]=1;

            for(int i=0;i<4;i++){
                int nrow= row +delrow[i];
                int ncol= col+ delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]=='O' ){
                    dfs(nrow,ncol,visited,board);
                }
            }
    }
}