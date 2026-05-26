class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int rows = grid.length, cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1 + dfs(row + 1, col, grid)
                 + dfs(row - 1, col, grid)
                 + dfs(row, col + 1, grid)
                 + dfs(row, col - 1, grid);
    }
}
