class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n= intervals.length;

        List<int[]> result= new ArrayList<>();

        int i=0;

        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        int mergeStart= newInterval[0];
        int mergeEnd= newInterval[1];

        while(i<n && intervals[i][0]<=newInterval[1]){
            mergeStart= Math.min(mergeStart, intervals[i][0]);
            mergeEnd= Math.max(mergeEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[]{mergeStart, mergeEnd});

        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

        
    }
}