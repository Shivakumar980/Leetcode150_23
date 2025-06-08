class Solution {
    int[] delrow={0,1,0, -1};
    int[] delcol={-1,0,1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n= heights.length;
        int m= heights[0].length;
        int[][] pacific=new int[n][m];
        int[][] atlantic= new int[n][m];

        for(int i=0; i< m; i++){
            dfs(0,i, heights, pacific, heights[0][i]);
            dfs(n-1,i, heights, atlantic, heights[n-1][i]);
        }

         for(int i=0; i< n; i++){
            dfs(i,0, heights, pacific, heights[i][0]);
            dfs(i,m-1, heights, atlantic, heights[i][m-1]);
        }

         List<List<Integer>> result= new ArrayList<>();
        for(int i=0 ; i< n; i++){
            for(int j=0; j< m ; j++){
                if( atlantic[i][j]==1 && pacific[i][j]==1){
                    result.add(Arrays.asList(i,j));
                }
              
            }
        }
        return result;
        


        
    }

    private void dfs(int row, int col, int[][] heights, int[][] visited, int prevHeight){
        if(row<0 || row==heights.length || col<0 || col== heights[0].length || prevHeight >  heights[row][col] || visited[row][col]==1 ){
            return;
        }
        visited[row][col]=1;
        for(int i=0; i< 4;i++){
            int nrow= row+ delrow[i];
            int ncol= col+ delcol[i];
            dfs(nrow, ncol, heights, visited, heights[row][col]);
        }
        return;
    }
}