class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //creat adj list

        //int n=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
         for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        //indegree
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
        ArrayList<Integer> courseList=new ArrayList<>();
       
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            courseList.add(node);
            for(int element:adj.get(node)){
                indegree[element]--;
                if(indegree[element]==0){
                    q.add(element);
                }
            }
        }
        if(courseList.size()!=numCourses){
            return new int[]{};
        }
        int n=courseList.size();
        int[] ans=new int[n];
        int index=0;
        for(int course:courseList){
            ans[index++]=course;
        }

        return ans;

    }
}