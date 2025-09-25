class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> result= new ArrayList<>();
        int n= intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int mergeStart= intervals[0][0];
        int mergeEnd= intervals[0][1];

        for(int i=1; i< n ; i++){
            if(intervals[i][0]<=mergeEnd){
                mergeEnd= Math.max(mergeEnd, intervals[i][1]);
            }
            else{
                result.add(new int[]{mergeStart,mergeEnd});
                mergeStart= intervals[i][0];
                mergeEnd=intervals[i][1];
            }
        }
        result.add(new int[]{mergeStart,mergeEnd});

        return result.toArray(new int[result.size()][]);
    }
}