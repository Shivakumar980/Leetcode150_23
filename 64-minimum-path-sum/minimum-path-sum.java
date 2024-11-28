class Solution {

    private int minPathSumUtil(int[][] dp, int row, int col, int[][] grid){

        if(row<0 || col<0) return (int)1e9;

        if(row==0 && col==0) return grid[0][0];

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int left= grid[row][col] + minPathSumUtil(dp,row,col-1,grid);
        int right= grid[row][col] + minPathSumUtil(dp,row-1,col,grid);

        return dp[row][col]=Math.min(left,right);
    }
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n=grid.length;
        int m=grid[0].length;

        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

       return minPathSumUtil(dp,n-1,m-1,grid);
    }
}