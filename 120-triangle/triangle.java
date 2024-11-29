class Solution {

    private int minimumTotalUtil(List<List<Integer>> triangle,int row,int col,int n,int m,int[][] dp){

        if(row==n) return triangle.get(row).get(col);

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int left=triangle.get(row).get(col)+minimumTotalUtil(triangle,row+1,col,n,m,dp);
        int right=triangle.get(row).get(col)+minimumTotalUtil(triangle,row+1,col+1,n,m,dp);

        return dp[row][col]=Math.min(left,right);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.size();

        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minimumTotalUtil(triangle,0,0,n-1,m-1,dp);
        
    }
}