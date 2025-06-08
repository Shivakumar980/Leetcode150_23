class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
          List<List<Integer>> adj= new ArrayList<>();

         for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        //direction of the edges is reverses
        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        int[] indegree= new int[numCourses];

        for(int[] edge:prerequisites){
            indegree[edge[0]]++;
        }

        Queue<Integer> q= new LinkedList<Integer>();

        for(int i=0; i< numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> result= new ArrayList<>();
        while(!q.isEmpty()){
            int node= q.poll();
            result.add(node);
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }

        }
       if (result.size()!= numCourses){
         return new int[]{};
       }
       int[] res=new int[numCourses];
       int index=0;

       for(int num:result){
        res[index++]=num;
       }

       return res;
    }
}