class Solution {
    private int n;
    private int m;
    public void solve(char[][] board) {
        m=board[0].length;
        n=board.length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                DFSMarking(board,i,0);
            }   
            if(board[i][m-1]=='O'){
                DFSMarking(board,i,m-1);
            }   
        }
        for(int j=1;j<m-1;j++){
            if(board[0][j]=='O'){
                DFSMarking(board,0,j);
            }      
            if(board[n-1][j]=='O'){
                DFSMarking(board,n-1,j);
            }      
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                   board[i][j]='X'; 
                }
                if(board[i][j]=='#'){
                   board[i][j]='O'; 
                }
            }
        }
        
    }

    private void DFSMarking(char[][] board,int rows,int columns){
        if(rows<0 || columns<0 || rows>=board.length || columns>=board[0].length || board[rows][columns]!='O'){
            return;
        }
        board[rows][columns]='#';
        DFSMarking( board, rows+1,columns );
        DFSMarking( board, rows-1,columns );
        DFSMarking( board, rows,columns+1 );
        DFSMarking( board, rows,columns-1 );

    }
}