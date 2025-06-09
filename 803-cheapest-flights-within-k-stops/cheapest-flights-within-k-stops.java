
class Tuple{
    int node;
    int weight;
    int steps;

    public Tuple(int node, int weight, int steps){
        this.node= node;
        this.weight= weight;
        this.steps= steps;
    }

}
class Pair{
    int node;
    int weight;

    public Pair(int node, int weight){
        this.node= node;
        this.weight= weight;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            List<List<Pair>> adj= new ArrayList<>();
            for(int i=0; i< n ;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] flight: flights){
                adj.get(flight[0]).add(new Pair(flight[1],flight[2]));
            }

            Queue<Tuple> q= new LinkedList<>();
            q.add(new Tuple(src,0, 0));

            int[] cost= new int[n];
            Arrays.fill(cost,(int)1e9);
            cost[src]=0;
            while(!q.isEmpty()){
                int node= q.peek().node;
                int weight=q.peek().weight;
                int steps=q.peek().steps;
                q.remove();
                if(steps>k){
                    continue;
                }

                for(Pair p: adj.get(node)){
                    int nd=p.node;
                    int wt=p.weight;
                    if(weight+wt< cost[nd]){
                        cost[nd]=weight+wt;
                        q.offer(new Tuple(nd, cost[nd],steps+1));
                    }
                }
            }
            return cost[dst]==(int)1e9 ? -1: cost[dst];
    }
}