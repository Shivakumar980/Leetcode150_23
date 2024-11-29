class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.size();

        int[][] dp=new int[n][m];
       
       for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
       }

       for(int row=n-2;row>=0;row--){
            for(int col=triangle.get(row).size()-1;col>=0;col--){
                dp[row][col]=triangle.get(row).get(col) + Math.min(dp[row+1][col], dp[row+1][col+1]);
            }
       }
       return dp[0][0];
        
    }
}