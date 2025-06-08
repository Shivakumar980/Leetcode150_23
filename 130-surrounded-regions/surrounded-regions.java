class Solution {
    int[] delrow= {0,-1,0,1};
    int[] delcol= {-1,0,1,0};
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int[][] visited= new int[n][m];

        for(int i=0; i< m ;i++){
            if(visited[0][i]==0 && board[0][i]=='O'){
                  dfs(0, i, board, visited);
            }
          
        }

        for(int i=0; i< m ;i++){
            if(visited[n-1][i]==0 && board[n-1][i]=='O'){
                  dfs(n-1, i, board, visited);
            }
          
        }

        for(int i=0; i< n ;i++){
            if(visited[i][0]==0 && board[i][0]=='O'){
                  dfs(i, 0, board, visited);
            }
          
        }
        for(int i=0; i< n ;i++){
            if(visited[i][m-1]==0 && board[i][m-1]=='O'){
                  dfs(i, m-1, board, visited);
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