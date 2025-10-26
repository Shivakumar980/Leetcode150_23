class Solution {
    int[] delrow={1,0,-1,0};
    int[] delcol={0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] visited= new int[n][m];

        int maxArea=0;
       
        for(int i=0; i< n; i++){
            for(int j=0; j<m ;j++){
                
                if(visited[i][j]==0 && grid[i][j]==1){
                    int area=dfs(i, j, visited, grid);
                    maxArea=Math.max(area, maxArea);
                }
            }
        }

        return maxArea;

    }

    private int dfs(int row, int col, int[][] visited, int[][] grid){
        visited[row][col]=1;
        int area=1;
        for(int i=0; i< 4; i++){
            int nrow= row+delrow[i];
            int ncol= col+delcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol< grid[0].length && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
            area+=dfs(nrow, ncol, visited, grid);
        }
        }
        
        return area;
    }
}