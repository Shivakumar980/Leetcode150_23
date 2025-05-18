class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> ans= new ArrayList<>();

        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        for(int[] interval : intervals){
            if(ans.size()==0 || ans.get(ans.size()-1)[1]<interval[0]){
                ans.add(interval);
            }
            else{
                int[] curr= ans.get(ans.size()-1);
                curr[0]=Math.min(interval[0],curr[0]);
                curr[1]=Math.max(interval[1],curr[1]);
            }
        }
       
        return ans.toArray(new int[ans.size()][]);

    }
}