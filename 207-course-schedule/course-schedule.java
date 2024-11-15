class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] indegree= new int[numCourses];

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            for(int element:adj.get(i)){
                indegree[element]++;
            }
        } 
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
            for(int element:adj.get(node)){
                indegree[element]--;
                if(indegree[element]==0){
                    q.add(element);
                }
            }
        }

       return count==numCourses;

    }
}