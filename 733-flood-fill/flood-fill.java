class Solution {

    int[] delrow={0,1,-1,0};
    int[] delcol={1,0,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n=image.length;
        int m=image[0].length;
        int[][] visited=new int[n][m];
        int originalColor=image[sr][sc];
        dfs(image,sr,sc,color,originalColor,visited);

       return image;
        
    }
    private void dfs(int[][] image,int sr ,int sc,int  color,int originalColor ,int[][] visited){
        image[sr][sc]=color;
        visited[sr][sc]=1;

        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
             int nrow=sr+delrow[i];
             int ncol=sc+delcol[i];
             if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==originalColor && visited[nrow][ncol]==0){
                dfs(image, nrow, ncol,color,originalColor, visited);
             }

        }
       
        return;
    }
}