class Solution {

    private void dfs(char[][] grid,int row,int col,int[] delrow,int[] delcol,int[][] visited){
        visited[row][col]=1;
       // grid[row][col]='0';
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                dfs(grid,nrow,ncol,delrow,delcol,visited);  
               
            }
        }
    
        
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] visited=new int[n][m];
        int[] delrow=new int[]{-1,0,1,0};
        int[] delcol=new int[]{0,1,0,-1};
     
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    
                    dfs(grid,i,j,delrow,delcol,visited);
                    count++;
                    
                }
               
            }
        }
        return count;
    }
}