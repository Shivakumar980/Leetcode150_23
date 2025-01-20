class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Pair> mp= new HashMap<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mp.put(mat[i][j], new Pair(i,j));
            }
        }
        int[] rowfreq=new int[n];
        int[] colfreq=new int[m];
        for(int i=0;i<m*n;i++){
            int row= mp.get(arr[i]).x;
            int col= mp.get(arr[i]).y;

            rowfreq[row]++;

            if(rowfreq[row]==m){
                return i;
            }
            colfreq[col]++;

            if(colfreq[col]==n){
                return i;
            }

        }
        return -1;
    }
}