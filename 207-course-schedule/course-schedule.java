
class Solution {
    private boolean detectCycle(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited){
        visited[node]=1;
        pathVisited[node]=1;
        for(int neighbour:adj.get(node)){
            if(visited[neighbour]==0){
                if(detectCycle(neighbour,adj,visited,pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[neighbour]==1){
                return true;
            }
        }
        pathVisited[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited=new int[numCourses];
        int[] pathVisited=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] row:prerequisites){
            adj.get(row[1]).add(row[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                boolean v=detectCycle(i,adj,visited,pathVisited);
                if(v){
                    System.out.println(v);
                    return false;
                }
            }
        }
        return true;
    }
 
}
