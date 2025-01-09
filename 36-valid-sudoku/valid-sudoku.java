class Solution {
    public boolean isValidSudoku(char[][] board) {

       

        for(int i=0;i<9;i++){
            HashSet<Character> rowset=new HashSet<>();
            for(int j=0 ;j<9 ;j++){
                if(rowset.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                     rowset.add(board[i][j]);
                }
               
            }
            HashSet<Character> colset=new HashSet<>();
            for(int j=0 ;j<9 ;j++){
                if(colset.contains(board[j][i])){
                    return false;
                }
                 if(board[j][i]!='.'){
                    colset.add(board[j][i]);
                }
                
            }
             
        }
        for(int box=0;box<9;box++){
            int i=box/3;
            int j=box%3;
            HashSet<Character> dgset=new HashSet<>();
            //System.out.println("hi");
            for(int row=3*i;row<3*i+3;row++){
                for(int col= 3*j;col<3*j+3; col++){
                   if(dgset.contains(board[row][col])){
                    return false;
                   }
                   if(board[row][col]!='.'){
                          dgset.add(board[row][col]);
                   }
                 
                }
            }
        }

            return true;
    }
        
     
}