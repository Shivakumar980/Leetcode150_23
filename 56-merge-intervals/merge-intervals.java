class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result= new ArrayList<>();

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        result.add(intervals[0]);
        
        int n= intervals.length;
        for(int i=1; i<n ; i++){
            int[] last= result.get(result.size()-1);

            if(last[1]>=intervals[i][0]){
                last[0]= Math.min(last[0],intervals[i][0] );
                last[1]= Math.max(last[1],intervals[i][1]);
            }
            else{
                last=intervals[i];
                result.add(intervals[i]);
            }
        }

        int m= result.size();
        int[][] ans= new int[m][2];
        for(int i=0 ;i<m ;i++){
            ans[i][0]=result.get(i)[0];
            ans[i][1]=result.get(i)[1];
        }

        return ans;
    }
}