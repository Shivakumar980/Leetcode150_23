class Tuple{
    int first;
    int second;
    int distance;

    public  Tuple(int first, int second, int distance){
        this.first= first;
        this.second= second;
        this.distance= distance;
    }
}
class Solution {
    int[] delrow={-1,0,1,0};
    int[] delcol={0,-1,0,1};
    public void wallsAndGates(int[][] rooms) {
        
        Queue<Tuple> q= new LinkedList<>();
        int n= rooms.length;
        int m= rooms[0].length;
        for(int i=0; i< n ; i++){
            for(int j=0; j< m; j++){
                if(rooms[i][j]==0){
                    q.add(new Tuple(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Tuple t= q.poll();
            int row= t.first;
            int col= t.second;
            int dist= t.distance;

            for(int i=0; i< 4; i++){
                int nrow= row+ delrow[i];
                int ncol= col+ delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol <m && rooms[nrow][ncol]!=-1 && rooms[nrow][ncol]> 1+dist){
                    rooms[nrow][ncol]= 1+dist;
                    q.add(new Tuple(nrow, ncol, rooms[nrow][ncol]));
                }
            }
        }

    }
}