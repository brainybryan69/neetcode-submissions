class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, high = 0, result = 0;
        boolean start = true;

        while (i < intervals.length) {
            int[] curr = intervals[i];
            if (start) {
                high = curr[1];
                start = false;
            } else {
                if (curr[0] < high) {
                    high = Math.min(high, curr[1]);
                    result++;
                } else {
                    start = true;
                    continue;
                }
            }
            i++;
        }
        return result;
    }
}
