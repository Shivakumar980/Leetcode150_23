class Pair{
    int node;
    int weight;
    public Pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {

        List<List<Pair>> adj= new ArrayList<>();
        int n= points.length;

        for(int i=0 ;i< n ;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i< n ;i++){
            for(int j=i+1; j< n ;j++){
                int distance= Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new Pair(j,distance));
                adj.get(j).add(new Pair(i,distance));
            }
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.weight-b.weight);
        int[] visited= new int[n];
        pq.add(new Pair(0,0));
       

        int total_cost=0;
        while(!pq.isEmpty()){
            int nd= pq.peek().node;
            int wt= pq.peek().weight;
            pq.poll();
            if(visited[nd]==1){
                continue;
            }
            total_cost+=wt;
            visited[nd]=1;
            for(Pair p: adj.get(nd)){
                int neighbor= p.node;
                int edgWt=p.weight;
                if(visited[neighbor]==0){
                    pq.offer(new Pair(neighbor, edgWt));
                }
            }
        }
        return total_cost;
        
    }
}