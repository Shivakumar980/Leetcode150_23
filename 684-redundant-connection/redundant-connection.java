class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        Disjoint disjoint =new Disjoint(n+1);
        for(int[] edge: edges){
            if(!disjoint.findUnion(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{-1,-1};
    }
}

class Disjoint{
    int[] rank;
    int[] parent;

    public Disjoint(int n){
        rank= new int[n];
        parent=new int[n];
        for(int i=0; i< n ;i++){
            parent[i]=i;
        }
    }

    public int findParent(int u){
        if(parent[u]!=u){
            parent[u]= findParent(parent[u]);
            return parent[u];
        }
        else{
            return parent[u];
        }
    }

    public boolean findUnion(int u , int v){
        int ulp_u= findParent(u);
        int ulp_v= findParent(v);

        if(ulp_u==ulp_v) return false;

        if(rank[ulp_u]> rank[ulp_v]){
            parent[ulp_v]=ulp_u;
        }
        else if( rank[ulp_u]< rank[ulp_v]){
            parent[ulp_u]= ulp_v;
        }
        else{
             parent[ulp_u]= ulp_v;
             rank[ulp_v]++;
        }

        return true;

    }


}