class Solution {
    int[] delrow={-1,0,1,0};
    int[] delcol={0,1,0,-1};
    private boolean dfs(char[][]board,int index,int row,int col,String word,int[][] visited){
        if(index==word.length()) return true;
    if( row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt(index)|| visited[row][col]==1){
        return false;
    }
       visited[row][col]=1;
       
       //if(word.charAt(index)!=board[row][col]) return false;

        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
             {
                    if(dfs(board,index+1,nrow,ncol,word,visited)){
                        return true;
                    }
            }
        }
        visited[row][col]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
       // int index=0;
        int[][] visited=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==(word.charAt(0))){
                    if(dfs(board,0,i,j,word,visited)){
                        return true;
                    }
                    //index++;
                }
            }
        }
        return false;
    }
}