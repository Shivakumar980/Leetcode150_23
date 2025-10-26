class Solution {
    int[] delrow= {1,0,-1,0};
    int[] delcol= {0,1,0,-1};
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int[][] visited=new int[n][m];
        for(int i=0; i< n ; i++){
            for(int j=0 ; j<m ;j++){
                if((i==0 || i==n-1 || j==0 || j==m-1) && visited[i][j]==0 && board[i][j]=='O'){
                    dfs(i, j, board, visited);
                }               
           }
        }
        for(int i=0; i< n ; i++){
            for(int j=0 ; j<m ;j++){
                if( visited[i][j]==0){
                   board[i][j]='X';
                }               
           }
        }


    }
    private void dfs(int row, int col, char[][] board, int[][] visited){
        visited[row][col]=1;
        int n= board.length;
        int m= board[0].length;
        for(int i=0; i<4 ;i++){
            int nrow= row+ delrow[i];
            int ncol= col+ delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, board, visited);
            }
        }

    }
}