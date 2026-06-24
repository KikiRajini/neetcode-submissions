

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort the intervals based on their END times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int eraseCount = 0;
        // Keep track of the end time of the last accepted interval
        int prevEnd = intervals[0][1];

        // Step 2: Loop through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // If the current interval overlaps with the previous one
            if (currentStart < prevEnd) {
                eraseCount++; // We must erase it
            } else {
                // No overlap! Update our boundary to the new end time
                prevEnd = currentEnd;
            }
        }

        return eraseCount;
    }
}