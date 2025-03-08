
class Triplet{

    int x;
    int y;
    double d;
    public Triplet(int x, int y, double z){
        this.x=x;
        this.y=y;
        this.d=z;
    }
}

    
    
    class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Triplet> pq= new PriorityQueue<>((a,b)->Double.compare(a.d, b.d));
        for(int[] point: points){
            int xc=point[0];
            int yc=point[1];
            double distance= Math.sqrt(xc*xc + yc*yc);

            pq.add(new Triplet(xc,yc,distance));
        }

        int[][] result= new int[k][2];
        int row=0;
        while(k>0){
            Triplet triplet= pq.remove();
            result[row][0]=triplet.x;
            result[row++][1]=triplet.y;
            k--;
        }
        return result;
    }
}