class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals array by start position
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        int low = 0, high = 0;
        boolean start = true;

        while (i < n) {
            int[] curr = intervals[i];
            if (start) {
                low = curr[0];
                high = curr[1];
                start = false;
            } else {
                if (low <= curr[0] && curr[0] <= high) {
                    high = Math.max(high, curr[1]);
                } else {
                    result.add(new int[] {low, high});
                    start = true;
                    continue;
                }
            }
            i++;
        }
        result.add(new int[] {low, high});
        return result.toArray(new int[result.size()][]);
    }
}
