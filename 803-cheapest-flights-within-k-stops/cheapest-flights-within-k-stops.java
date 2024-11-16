class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Tuple{
    int node;
    int weight;
    int stops;
    public Tuple(int node,int weight,int stops){
        this.node=node;
        this.weight=weight;
        this.stops=stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        int m=flights.length;

        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> pq=new LinkedList<>();
        int[] distance=new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        pq.add(new Tuple(src,0,0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int wt=pq.peek().weight;
            int stops=pq.peek().stops;
            pq.remove();
            if(stops>k) continue;
           
            for(Pair pair:adj.get(node)){
                int nd=pair.node;
                int edgWt=pair.weight;

                if(stops<=k && wt+edgWt<distance[nd]){
                    distance[nd]=wt+edgWt;
                    pq.add(new Tuple(nd,distance[nd],1+stops));
                }
            }


        }
        if(distance[dst]==(int)1e9){
            return -1;
        }
        return distance[dst];
    }
}