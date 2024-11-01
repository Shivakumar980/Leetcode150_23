class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        for(int i=0;i<n;i++ ){
            if(ans.size()==0 || ans.get(ans.size()-1).get(1)< intervals[i][0]){
                ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }
            else{
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),intervals[i][1]));
            }

        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;

    }
}