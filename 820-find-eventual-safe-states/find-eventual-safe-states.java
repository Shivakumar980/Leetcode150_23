class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n=graph.length;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int element:graph[i]){
                adj.get(element).add(i);
            }
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int element:graph[i]){
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> al=new ArrayList<>();
        
        while(!q.isEmpty()){
            int node=q.peek();
            al.add(node);
            q.remove();
            for(int element: adj.get(node)){
                indegree[element]--;
                if(indegree[element]==0){
                    q.add(element);
                }
            }
        }
        Collections.sort(al);
        return al;
        
    }
}