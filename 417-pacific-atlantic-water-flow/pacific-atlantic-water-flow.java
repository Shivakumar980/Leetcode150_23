class Solution {
    int[] delrow= {1,0,-1,0};
    int[] delcol= {0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n= heights.length;
        int m= heights[0].length;

        int[][] v_pacific= new int[n][m];
        int[][] v_atlantic= new int[n][m];

        for(int i= 0; i< m ;i++){
            dfs(0,i,v_pacific, heights);
            dfs(n-1, i, v_atlantic, heights);
        }
        for(int i= 0; i< n ;i++){
            dfs(i,0, v_pacific, heights);
            dfs(i,m-1,v_atlantic, heights);
        }

        List<List<Integer>> result= new ArrayList<>();
        for(int i=0; i<n ; i++){
            for(int j=0; j< m ; j++){
                if(v_pacific[i][j]==1 && v_atlantic[i][j]==1){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;


    }

    private void dfs(int row, int col, int[][] visited, int[][] heights){
        visited[row][col]=1;
        int n= heights.length;
        int m= heights[0].length;

        for(int i=0; i< 4 ;i++){
            int nrow= row+delrow[i];
            int ncol= col+delcol[i];

            if(nrow>=0 && nrow< n &&  ncol>=0 && ncol<m  && visited[nrow][ncol]==0 && heights[nrow][ncol]>=heights[row][col]){
                dfs(nrow, ncol, visited, heights);
            }
        }

    }
}