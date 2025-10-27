class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0 ; i<numCourses ;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree= new int[numCourses];
        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0 ; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int size=0;
        while(!q.isEmpty()){
            int node= q.peek();
            size+=1;
            q.poll();
            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }
       
        return size==numCourses;
        

    }
}