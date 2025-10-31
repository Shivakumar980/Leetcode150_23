class Pair{
    int node;
    int weight;

    public Pair(int node, int weight){
        this.node= node;
        this.weight= weight;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n=points.length;
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n ; i++){
            int x1=points[i][0];
            int y1=points[i][1];

            for(int j=i+1; j<n ; j++){
                int x2= points[j][0];
                int y2= points[j][1];
                
                int dist= Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.get(i).add(new Pair(j,dist));
                adj.get(j).add(new Pair(i,dist));
            }

        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        int[] visited= new int[n];

        pq.offer(new Pair(0,0));

        int res=0;
        while(!pq.isEmpty()){
            int nd= pq.peek().node;
            int wt= pq.peek().weight;
            pq.poll();
            if(visited[nd]==1) continue;
            visited[nd]=1;
            res+=wt;
            for(Pair p: adj.get(nd)){
                int nnd=p.node;
                int wwt=p.weight;
                if(visited[nnd]==0){
                    pq.offer(p);
                }
                
            }

        }

        return res;
        

        
    }
}