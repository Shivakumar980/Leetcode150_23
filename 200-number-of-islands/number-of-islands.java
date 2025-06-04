class Solution {
    int[] delrow={0,1,0,-1};
    int[] delcol={1,0,-1,0};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] visited=new int[n][m];
        for(int i=0; i< n; i++){
            for(int j=0;j<m ;j++ ){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid, int[][] visited){

        if(row<0 || row==grid.length || col<0 || col==grid[0].length || grid[row][col]=='0' || visited[row][col]==1){
            return;
        }
        visited[row][col]=1;
        for(int i=0; i< 4; i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            dfs(nrow,ncol, grid,visited);
        }
        return;
    }
}