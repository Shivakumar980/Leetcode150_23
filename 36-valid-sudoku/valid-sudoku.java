class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        
        for(int i=0; i< n ;i++){
            HashSet<Character> hs= new HashSet<>();
            for(int j=0; j< m;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(hs.contains(board[i][j])){
                    return false;
                }
                hs.add(board[i][j]);
            }
        }
         
        for(int i=0; i< n ;i++){
             HashSet<Character> hs1= new HashSet<>();
            for(int j=0; j< m;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(hs1.contains(board[j][i])){
                    return false;
                }
                hs1.add(board[j][i]);
            }
        }
 
        for(int box=0; box<9 ;box++){
 HashSet<Character> hs2= new HashSet<>();
                int row= (box/3)*3;
                int col= (box%3)*3;

                for(int i=row; i<3+row; i++){
                    for(int j=col; j<3+col; j++){

                         if(board[i][j]=='.'){
                    continue;
                }
                if(hs2.contains(board[i][j])){
                    return false;
                }
                hs2.add(board[i][j]);

                    }
                }


        }
        return true;
    }
}