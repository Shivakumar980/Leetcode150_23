class Pair{
    int node;
    int weight;

    public Pair(int node, int weight){
        this.node= node;
        this.weight= weight;
    }
}

class Disjoint{
    int[] rank;
    int[] parent;

    public Disjoint(int n){
        rank= new int[n];
        parent= new int[n];

        for(int i=0; i< n ;i++){
            rank[i]=1;
            parent[i]=i;
        }
    }

        public int findParent(int x){
            if(x!=parent[x]){
                parent[x]=findParent(parent[x]);
                return parent[x];
            }
            else{
                return x;
            }
        }

        public boolean union(int u, int v){
            int ulp_u= findParent(u);
            int ulp_v= findParent(v);

            if(ulp_u==ulp_v) return false;
            
            if(rank[ulp_u]<rank[ulp_v]){
                parent[ulp_u]=ulp_v;
            }
            else if(rank[ulp_v]< rank[ulp_u]){
                parent[ulp_v]=ulp_u;
            }
            else{
                parent[ulp_u]=ulp_v;
                rank[ulp_v]++;
            }
            return true;
        }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n=points.length;
        List<int[] > adj= new ArrayList<>();
        for(int i=0; i<n ; i++){
            int x1=points[i][0];
            int y1=points[i][1];

            for(int j=i+1; j<n ; j++){
                int x2= points[j][0];
                int y2= points[j][1];
                
                int dist= Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.add(new int[]{i,j, dist});
                //adj.get(j).add(new Pair(i,dist));
            }
        }
        Collections.sort(adj, (a,b)->a[2]-b[2]);
        Disjoint dj= new Disjoint(n);
        int res=0;
        for(int[] tuple:adj){
            if(dj.union(tuple[0],tuple[1])){
                res+=tuple[2];
            }
        }

        return res;

        
    }

}