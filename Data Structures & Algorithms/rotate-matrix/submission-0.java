class Solution {
    public void rotate(int[][] matrix) {
        // Reverse matrix vertically
        int n = matrix.length;
        for (int top = 0, bottom = n - 1; top < bottom; top++, bottom--) {
            int[] tmp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = tmp;
        }

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
