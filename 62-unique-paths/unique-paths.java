class Solution {

    private int solvePaths(int row,int col, int[][] dp,int m,int n){
        if(row<0 || col <0 || row >=m || col>=n) return 0;
        if(row==0 && col==0) return 1;

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int left= solvePaths(row-1,col,dp,m,n);
        int right=solvePaths(row,col-1,dp,m,n);
        
        return dp[row][col]=left+right;

        
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return solvePaths(m-1,n-1,dp,m,n);
    }
}