
class Solution {
   
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //int[] visited=new int[numCourses];
       // int[] pathVisited=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] row:prerequisites){
            adj.get(row[1]).add(row[0]);
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int row:adj.get(i)){
                indegree[row]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            count++;
            for(int neighbour:adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }

        }
        return numCourses==count;
    }
 
}
