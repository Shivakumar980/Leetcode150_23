class Solution {

    private int solve(int[][] obstacleGrid,int[][] dp,int row,int col){
        if(row<0 || col <0) return 0;
        if(obstacleGrid[row][col]==1) return 0;
        if(row==0 && col==0) return 1;
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int left=solve(obstacleGrid,dp,row,col-1);
        int up=solve(obstacleGrid,dp,row-1,col);

        return dp[row][col]=up+left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(obstacleGrid,dp,n-1,m-1);
    }
}