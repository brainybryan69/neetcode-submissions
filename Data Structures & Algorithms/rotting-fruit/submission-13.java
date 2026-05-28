class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
