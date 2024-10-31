class Solution {
    public void rotate(int[][] matrix) {

        int bottom =matrix.length-1;
        int right=matrix[0].length-1;
        int left=0;
        int top=0;
        while(top<bottom &&left<right){

             for(int i=0;i<right-left;i++){
                    int temp=matrix[top][left+i];
                    matrix[top][left+i]=matrix[bottom-i][left];
                    matrix[bottom-i][left]=matrix[bottom][right-i];
                    matrix[bottom][right-i]=matrix[top+i][right];
                    matrix[top+i][right]=temp;

                }
                top++;
                bottom--;
                left++;
                right--;
        }
       


        
    }
}