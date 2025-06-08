class Pair{
    int node;
    int distance;
    public Pair(int node, int distance){
        this.node= node;
        this.distance= distance;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0 ; i<= n ;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int[] time : times){
            
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }

        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.distance-b.distance);
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node= p.node;
            int distance=p.distance;

            for(Pair pr: adj.get(node)){
                int nd= pr.node;
                int d= pr.distance;
                if(distance+d < dist[nd]){
                    dist[nd]= distance+d;
                    pq.offer(new Pair(nd, dist[nd]));
                }
            }
        }
        int mini=0;
        for(int i=1; i<= n ;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            mini= Math.max(mini, dist[i]);
        }
        return mini;
        
    }
}