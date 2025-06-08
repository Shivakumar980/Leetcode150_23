class Solution {
    int[] delrow= {0,-1,0,1};
    int[] delcol= {-1,0,1,0};
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int[][] visited= new int[n][m];

        for(int i=0 ; i< n ;i++){
            for(int j=0 ; j< m ; j++){
                if(visited[i][j]==0 && (i==0 || i==n-1||j==0 || j==m-1) && board[i][j]=='O'){
                   dfs(i, j, board, visited);
                }
            }
        }

        for(int i=0 ; i< n ;i++){
            for(int j=0 ; j< m ; j++){
                if(visited[i][j]==0 && i!=0 && i!=n-1 && j!=0 && j!=m-1){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board, int[][] visited){
        if(row<0 || col<0 || row==board.length || col==board[0].length || visited[row][col]==1 || board[row][col]=='X'){
            return;
        }
        visited[row][col]=1;
        for(int i=0 ; i< 4; i++){
            int nrow= row+delrow[i];
            int ncol= col+delcol[i];

            dfs(nrow, ncol, board, visited);
        }
        return;
    }
}