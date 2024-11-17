class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        int m=times.length;

        for(int i=0;i<m;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        //Queue<Pair> q=new LinkedList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] distance=new int[n+1];
        Arrays.fill(distance,(int)1e9);
        distance[k]=0;
        q.add(new Pair(k,0));

        while(!q.isEmpty()){
            int node=q.peek().node;
            int wt=q.peek().weight;
            q.remove();

            for(Pair pair:adj.get(node)){
                int nd=pair.node;
                int edgWt=pair.weight;
                if(wt+edgWt<distance[nd]){
                    distance[nd]=wt+edgWt;
                    q.add(new Pair(nd,distance[nd]));
                }
            }

        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(distance[i]==(int)1e9){
                return -1;
            }
            else{
                ans=Math.max(ans,distance[i]);
            }
            
        }

        return ans;
    }
}