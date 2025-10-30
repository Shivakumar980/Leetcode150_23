class Pair{
    int node;
    int weight;

    public Pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<= n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(k,0));
        int[] dist= new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k]=0;
        while(!pq.isEmpty()){
            int node= pq.peek().node;
            int time= pq.peek().weight;
            pq.poll();

            for(Pair p: adj.get(node)){
                int nd=p.node;
                int wt=p.weight;

                if( wt + time< dist[nd]){
                    dist[nd]= wt+time;
                    pq.add(new Pair(nd, dist[nd]));
                }
            }

        }
        int res= Integer.MIN_VALUE;
        for(int i=1; i<=n ;i++){
            if(dist[i]==(int)1e9) return -1;
            else{
                res= Math.max(res, dist[i]);
            }
        }
        return res;
    }
}