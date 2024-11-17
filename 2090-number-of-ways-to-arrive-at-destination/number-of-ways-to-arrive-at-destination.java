class Pair{
    long node;
    long distance;

    public Pair(long node,long distance){
        this.node=node;
        this.distance=distance;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        int m=roads.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long[] dist=new long[n];
        long[] ways=new long[n];
        ways[0]=1;
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((Pair1, Pair2) -> Long.compare(Pair1.distance, Pair2.distance));
        dist[0]=0;
        pq.add(new Pair(0,0));


        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            long node=pq.peek().node;
            long distance=pq.peek().distance;
            pq.remove();

            for(Pair pair:adj.get((int)node)){
                long nd=pair.node;
                long wt=pair.distance;

                if(wt+distance< dist[(int)nd]){
                    dist[(int)nd]=(wt+distance);
                    pq.add(new Pair(nd,dist[(int)nd]));
                    ways[(int)nd]=ways[(int)node];
                }
                else if(wt+distance ==dist[(int)nd]){
                    ways[(int)nd]=(ways[(int)nd]+ways[(int)node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}