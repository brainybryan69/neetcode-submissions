class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        for (int i  = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') dfs(0, i, board);
            if (board[board.length - 1][i] == 'O') dfs(board.length - 1, i, board);
        }
        
        for (int j = 1; j < board.length - 1; j++) {
            if (board[j][0] == 'O') dfs(j, 0, board);
            if (board[j][board[0].length - 1] == 'O') dfs(j, board[0].length - 1, board);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '#') board[r][c] = 'O';
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        board[row][col] = '#'; // mark grids where are unchanged
        for (int[] direction : directions) {
            int nr = row + direction[0];
            int nc = col + direction[1];
            if (nr >= 0 && nr < board.length 
            && nc >= 0 && nc < board[0].length
            && board[nr][nc] == 'O') dfs(nr, nc, board);
        }
    }
}
