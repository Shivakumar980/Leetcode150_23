class Solution {
    int[] delrow={-1,1,0,0};
    int[] delcol={0,0,-1,1};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] visited= new int[n][m];
        int count=0;
        for(int i=0; i<n ;i++){
            for(int j=0; j<m ; j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    dfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] visited, char[][] grid){
        visited[row][col]=1;
        for(int i=0; i<4; i++ ){
            int nrow= row+delrow[i];
            int ncol= col+delcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(nrow, ncol, visited, grid);
            }
        }
    }
}