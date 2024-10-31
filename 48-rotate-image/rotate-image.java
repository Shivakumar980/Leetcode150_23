class Solution {
    public void rotate(int[][] matrix) {

        int bottom =matrix.length;
        int right=matrix[0].length;
        int left=0;
        int top=0;
        while(top<bottom &&left<right){

             for(int i=0;i<right-1-left;i++){
                    int temp=matrix[top][left+i];
                    matrix[top][left+i]=matrix[bottom-1-i][left];
                    matrix[bottom-1-i][left]=matrix[bottom-1][right-1-i];
                    matrix[bottom-1][right-1-i]=matrix[top+i][right-1];
                    matrix[top+i][right-1]=temp;

                }
                top++;
                bottom--;
                left++;
                right--;
        }
       


        
    }
}