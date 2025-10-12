class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n= board.length;
        int m=board[0].length;

        for( int i=0 ; i< n ; i++){
            HashSet<Character> hs= new HashSet<>();
            for(int j=0; j< m ; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(hs.contains(board[i][j])){
                    return false;
                }
                hs.add(board[i][j]);
            }
        }

        for( int j=0 ; j< m ; j++){
            HashSet<Character> hs= new HashSet<>();
            for(int i=0; i< n ; i++){
                 if(board[i][j]=='.'){
                    continue;
                }
                if(hs.contains(board[i][j])){
                    return false;
                }
                hs.add(board[i][j]);
            }
        }

        for(int box=0 ; box < 9 ; box++){
             HashSet<Character> hs= new HashSet<>();
            int row= 3*(box/3);
            int col= 3* (box%3);
            for( int i= row ; i < row+ 3 ; i++){
                 for( int j= col ; j <  col + 3 ; j++){
                     if(board[i][j]=='.'){
                        continue;
                        }

                     if(hs.contains(board[i][j])){
                    return false;
                    }
                    hs.add(board[i][j]);
                 }
            }
        }
        return true;
    }

}