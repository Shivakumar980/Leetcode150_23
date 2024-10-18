class Solution {
    public int uniquePaths(int m, int n) {
         int[][] dp=new int[m][n];
         for(int[] inner:dp){
            Arrays.fill(inner,-1);
         }
         return uniquePathsUtil(m- 1,n-1,dp);
    }
    public int uniquePathsUtil(int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=uniquePathsUtil(i-1,j,dp);
        int right=uniquePathsUtil(i,j-1,dp);
        return dp[i][j]=left+right;

    }
}