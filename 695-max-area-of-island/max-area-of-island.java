class Solution {
    int[] delrow={0,-1,0,1};
    int[] delcol={-1,0,1,0};
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] visited=new int[n][m];
        
        int maxarea=0;
        for(int i=0; i< n; i++){
            for(int j=0;j<m ;j++ ){
                if(grid[i][j]==1 && visited[i][j]==0){
                    int[] area={0};
                    area=dfs(i, j, grid, visited,area);
                    maxarea= Math.max(maxarea,area[0]);
                }
            }
        }
        return maxarea;
    }

    private int[] dfs(int row, int col, int[][] grid, int[][] visited,int[] area){

        if(row<0 || row==grid.length || col<0 || col==grid[0].length || grid[row][col]==0 || visited[row][col]==1){
            return area;
        }
        visited[row][col]=1;
        area[0]+=1;
        for(int i=0; i< 4; i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            dfs(nrow,ncol, grid,visited,area);
        }
        
        System.out.println(area[0]);
        return area;
    }
}