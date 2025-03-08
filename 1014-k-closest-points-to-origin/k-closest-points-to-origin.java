
class Triplet{

    int x;
    int y;
    int d;
    public Triplet(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.d=z;
    }
}

    
    
    class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Triplet> pq= new PriorityQueue<>((a,b)->b.d-a.d);
        for(int[] point: points){
            int xc=point[0];
            int yc=point[1];
            int distance= xc*xc + yc*yc;

            pq.add(new Triplet(xc,yc,distance));
            if(pq.size()>k){
                pq.poll();
            }
            
        }

        int[][] result= new int[k][2];
        int row=0;
        while(!pq.isEmpty()){
            Triplet triplet= pq.poll();
            result[row][0]=triplet.x;
            result[row++][1]=triplet.y;
        }
        return result;
    }
}