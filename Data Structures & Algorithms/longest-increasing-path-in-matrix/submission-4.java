class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int ROWS;
    int COLS;
    int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        this.matrix = matrix;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        return result;
    }

    private int dfs(int i, int j) {
        int key = i * COLS + j;
        if (map.containsKey(key)) return map.get(key);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int longest = 1;

        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            if (nx >= 0 && nx < ROWS && ny >= 0 && ny < COLS && matrix[nx][ny] > matrix[i][j]) {
                longest = Math.max(longest, 1 + dfs(nx, ny));
            }
        }

        map.put(key, longest);
        return longest;
    }
}
