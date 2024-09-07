class Solution {

    private void dfs(int row,int col,int minutes, int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m) return;
        if(grid[row][col] != 1 && grid[row][col] < minutes) return; 
        grid[row][col] = minutes;
        int delrow[]=new int[]{-1,0,1,0};
        int delcol[]=new int[]{0,-1,0,1};
        for(int i=0;i<4;i++){
            int nRow=row+delrow[i];
            int nCol=col+delcol[i];

                // Continue to rot adjacent oranges recursively
                dfs(nRow, nCol, minutes + 1, grid);
            }
        }

    



    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int time=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    dfs(i,j,2,grid);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                time=Math.max(time,grid[i][j]);
            }
        }

        return time-2;

        
    }
}