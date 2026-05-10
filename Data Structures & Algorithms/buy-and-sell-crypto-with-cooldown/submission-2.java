class Solution {
    int[][] dp;
    int[] prices;

    private int dfs(int i, boolean can_buy) {
        if (i >= prices.length) return 0;
        int b = can_buy ? 1 : 0;
        if (dp[b][i] != 0) return dp[b][i];

        if (can_buy) {
            int buy = dfs(i + 1, false) - prices[i];
            int cooldown = dfs(i + 1, true);
            dp[b][i] = Math.max(
                buy, cooldown
            );
        } else {
            int sell = dfs(i + 2, true) + prices[i];
            int cooldown = dfs(i + 1, false);
            dp[b][i] = Math.max(
                sell, cooldown
            );
        }
        return dp[b][i];

    }

    public int maxProfit(int[] prices) {
        this.dp = new int[2][prices.length + 1];
        this.prices = prices;
        
        return dfs(0, true);
    }
}
