class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = 0;
                    cols[c] = 0;
                }
            }
        }

        for (int r = 0; r < rows.length; r++) {
            if (rows[r] == 0) {
                for (int c = 0; c < matrix[0].length; c++) matrix[r][c] = 0;
            }
        }

        for (int c = 0; c < cols.length; c++) {
            if (cols[c] == 0) {
                for (int r = 0; r < matrix.length; r++) matrix[r][c] = 0;
            }
        }
    }
}
