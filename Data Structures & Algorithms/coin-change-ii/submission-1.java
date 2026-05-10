class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {
        this.dp = new int[coins.length][amount + 1];

        Arrays.sort(coins);
        return dfs(coins, 0, amount);
    }

    private int dfs(int[] coins, int i, int amount) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (dp[i][amount] != 0) return dp[i][amount];

        for (int j = i; j < coins.length; j++) {
            dp[i][amount] += dfs(coins, j, amount - coins[j]);
        }
        return dp[i][amount];
    }
}
