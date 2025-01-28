class Solution {

    int[] delrow= {0,1,0,-1};
    int[] delcol= {-1,0,1,0};
    int n=0;
    int m=0;
    public int findMaxFish(int[][] grid) {

         n= grid.length;
         m= grid[0].length;
        int[][] vis= new int[n][m];

        int ans= 0;
        for(int i=0 ; i<n ;i++){
            for(int j=0; j<m ;j++){
                if(vis[i][j]==0 && grid[i][j]!=0){
                    int sum= dfs(i, j , grid, vis, new int[]{0});
                    ans= Math.max(sum, ans);
                }

            }
        }
        return ans;

        
    }

    private int dfs(int row, int col , int[][] grid,int[][] vis, int[] sum){
       
        vis[row][col]=1;
        sum[0]+=grid[row][col];

        for(int i=0; i< 4; i++){
            int nrow= row + delrow[i];
            int ncol= col+ delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  vis[nrow][ncol]==0 && grid[nrow][ncol]!=0 ){
                dfs(nrow,ncol, grid, vis, sum);
            }
        }
        System.out.println(sum[0]);
        return sum[0];
    }
}