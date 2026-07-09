class Solution {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2]; // padding
        balloons[0] = 1;
        balloons[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) balloons[i + 1] = nums[i];

        int[][] dp = new int[balloons.length][balloons.length]; // define dp

        for (int len = 2; len < balloons.length; len++) {
            for (int i = 0; i + len < balloons.length; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + balloons[i] * balloons[k] * balloons[j] + dp[k][j]);
                }
            }
        }

        return dp[0][balloons.length - 1];
    }
}
