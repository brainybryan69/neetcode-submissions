class Solution {
    int[] prices;
    int length;
    int[][] dp;

    private int helper(int day, boolean can_buy) {
        if (day >= length + 1) return 0;

        int b = can_buy ? 1 : 0;
        if (dp[b][day] != 0) return dp[b][day];

        if (can_buy) {
            dp[b][day] = Math.max(
                helper(day + 1, false) - prices[day - 1],
                helper(day + 1, true)
            );
        } else {
            dp[b][day] = Math.max(
                helper(day + 2, true) + prices[day - 1],
                helper(day + 1, false)
            );
        }

        return dp[b][day];
    }
    
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.length = prices.length;
        this.dp = new int[2][length + 2];
        return helper(1, true);
    }
}
