import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;  // Counter for the number of intervals to remove
        int end = intervals[0][1];  // End time of the last non-overlapping interval
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlapping interval found
                count++;
            } else {
                // Update the end to the current interval's end
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}
