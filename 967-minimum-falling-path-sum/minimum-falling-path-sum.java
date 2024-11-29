class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] dp= new int[n][m];

        for(int col=0;col<m;col++){
            dp[0][col]=matrix[0][col];
        }
        for(int row=1;row<n;row++){
            for(int col=0;col<m;col++){
                int topleft=(int)1e9;
                if(col-1>=0){
                    topleft=matrix[row][col] + dp[row-1][col-1];
                }

                int topup=matrix[row][col] + dp[row-1][col];

                int topright=(int)1e9;
                if(col+1<m){
                    topright=matrix[row][col] + dp[row-1][col+1];
                }
                dp[row][col]=Math.min(topleft,Math.min(topup,topright));
            
            }
        }

        int minval=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            minval=Math.min(minval, dp[n-1][j]);
        }


      return minval;  
 
    }
}