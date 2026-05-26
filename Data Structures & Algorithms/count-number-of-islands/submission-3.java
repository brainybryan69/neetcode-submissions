class Solution {
    private int num = 0;

    public int numIslands(char[][] grid) {
        int numIslands = 0;

        int rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') num++;
                dfs(r, c, grid);
            }
        }

        return num;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        if (grid[row][col] == '0') return;

        grid[row][col] = '0';

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}
