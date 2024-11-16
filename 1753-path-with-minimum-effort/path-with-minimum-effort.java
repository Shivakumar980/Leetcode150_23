class Pair{
    int first;
    int second;
    int effort;
    public Pair(int first, int second,int effort){
        this.first=first;
        this.second=second;
        this.effort=effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};

        int n=heights.length;
        int m=heights[0].length;
        int[][] effortArray=new int[n][m];
        for(int[] row:effortArray){
            Arrays.fill(row,(int)1e9);
        }
        effortArray[0][0]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.effort-b.effort);
        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty()){
            int row=pq.peek().first;
            int col=pq.peek().second;
            int effort=pq.peek().effort;
            pq.remove();

            if(row == n-1 && col == m-1) return effort; 
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m ){

                    int currEffort=Math.abs(heights[nrow][ncol]-heights[row][col]);
                   int  newEffort=Math.max(currEffort,effort);
                    if(newEffort<effortArray[nrow][ncol]){
                        effortArray[nrow][ncol]=newEffort;
                        pq.add( new Pair(nrow,ncol,newEffort));
                    }

                }
            }
        }

        return effortArray[n-1][m-1];
    }
}