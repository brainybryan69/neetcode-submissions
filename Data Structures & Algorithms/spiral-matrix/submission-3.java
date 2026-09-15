class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bot && left <= right) {
            // top, left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // right, top to bot
            for (int row = top; row <= bot; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // bot, right to left
            if (top <= bot) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bot][col]);
                }
                bot--;
            }
            
            // left, bot to top
            if (left <= right) {
                for (int row = bot; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}
