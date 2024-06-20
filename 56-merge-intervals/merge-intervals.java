class Solution {
    public int[][] merge(int[][] intervals) {
       if (intervals.length == 0) {
            return new int[0][0];
        }

        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a list to collect merged intervals
        List<int[]> merged = new ArrayList<>();

        // Initialize the first interval as the current interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // There is an overlap, so merge the intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, update the current interval and add to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convert the list back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}