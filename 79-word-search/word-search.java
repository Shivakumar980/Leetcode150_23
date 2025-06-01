class Solution {
    int[] delrow= {0,-1,0,1};
    int[] delcol= {-1,0,1,0};
    public boolean exist(char[][] board, String word) {
        int n= board.length;
        int m= board[0].length;
        int[][] visited= new int[n][m];

        for(int i=0 ; i< n ;i++){
            for(int j=0 ; j< m ;j++){
                if(word.charAt(0)==board[i][j]){
                     if(dfs(i,j, 0, visited, word,board)){
                    return true;
                    }
                }
               
            }
        }

        return false;

    }
    private boolean dfs(int row, int col,int index, int[][] visited, String word, char[][] board){
        if(word.length()==index) return true;
        if(row<0 || row>= board.length || col<0 || col>= board[0].length || visited[row][col]==1 || board[row][col]!=word.charAt(index) ){
            return false;
        }
        visited[row][col]=1;
        for( int i=0 ; i< 4; i++){
            int nrow= row+delrow[i];
            int ncol= col+delcol[i];

            if(dfs(nrow, ncol, index+1, visited, word, board)){
                return true;
            }
            
        }

        visited[row][col]=0;
        return false;
    }
}