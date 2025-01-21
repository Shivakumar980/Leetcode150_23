class Solution {
    public long gridGame(int[][] grid) {
        int n= grid[0].length;

        long[] prefix1= new long[n];
        long[] prefix2= new long[n];
        prefix1[0]=grid[0][0];
        prefix2[0]=grid[1][0];

        for(int i=1;i<n;i++){
            prefix1[i]=grid[0][i]+ prefix1[i-1];
            prefix2[i]=grid[1][i]+ prefix2[i-1];
        }

        long res= Long.MAX_VALUE;

        for(int i=0; i<n ;i++){
            long top= prefix1[n-1]- prefix1[i];
            long bottom= i>0 ? prefix2[i-1] :0 ;

            long secondrobot = Math.max(top,bottom);
            res = Math.min(res, secondrobot);
        }
        return res;
        
    }
}