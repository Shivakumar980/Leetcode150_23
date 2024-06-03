class Solution {

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                        rows.add(i);
                        cols.add(j);
                }
            }

        }
        for(int element:rows){
            for(int i=0;i<n;i++){
                matrix[element][i]=0;
            }
           
        }
        for(int element:cols){
         for(int i=0;i<m;i++){
                matrix[i][element]=0;
            }
        }
    }
}