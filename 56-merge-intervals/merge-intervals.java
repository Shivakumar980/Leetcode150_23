class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        int[] prev_row = intervals[0];
        ans.add(prev_row);
        for(int[] interval:intervals){
            int prevEnd=prev_row[1];
            int currStart=interval[0];
            int currEnd=interval[1];

            if(prevEnd>=currStart){
                prev_row[1]=Math.max(prevEnd,currEnd);
            }
            else{
                prev_row = interval;
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][2]);

    }
}
        // int prev_first=intervals[0][0];
        // int prev_second=intervals[0][1];
        /*
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= prev_second) {
                int max = Math.max(prev_second, intervals[i][1]);
                curr_row[1] = max;
                
                 * if(intervals[i][1]>=prev_second){
                 * ans[index][1]=intervals[i][1];
                 * }
                 * else{
                 * ans[index][1]=prev_second;
                 * }
                

            } else {
                prev_second = intervals[i][0];
                ans.add(intervals[i]);
            }
        }
         */
       
