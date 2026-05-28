class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) queue.offer(new int[]{r, c});
            }
        }

        int counter = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (isValid(nr, nc, grid)) {
                        grid[nr][nc] = counter;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            counter++;
        }
        return;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return false;
        if (grid[row][col] != Integer.MAX_VALUE) return false;
        return true;
    }
}
