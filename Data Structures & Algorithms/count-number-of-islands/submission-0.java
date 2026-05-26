class Solution {
    private int num = 0;

    public int numIslands(char[][] grid) {
        int numIslands = 0;

        int rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                bfs(r, c, grid, true);
            }
        }

        return num;
    }

    private void bfs(int row, int col, char[][] grid, boolean first) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        if (grid[row][col] == '0') return;

        grid[row][col] = '0';

        bfs(row + 1, col, grid, false);
        bfs(row - 1, col, grid, false);
        bfs(row, col + 1, grid, false);
        bfs(row, col - 1, grid, false);

        if (first) num++;
    }
}
