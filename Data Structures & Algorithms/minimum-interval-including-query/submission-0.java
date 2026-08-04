class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] interval : intervals) {
            int left = interval[0], right= interval[1];
            int length = right - left + 1;

            for (int i = left; i <= right; i++) {
                map.put(i, Math.min(map.getOrDefault(i, Integer.MAX_VALUE), length));
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i], -1);
        }
        return result;
    }
}
