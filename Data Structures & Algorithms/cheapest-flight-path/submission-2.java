class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                if (prices[flight[0]] != Integer.MAX_VALUE && prices[flight[0]] + flight[2] < temp[flight[1]]) {
                    temp[flight[1]] = prices[flight[0]] + flight[2];
                }
            }
            prices = temp;
        }

        if (prices[dst] == Integer.MAX_VALUE) return -1;
        return prices[dst];
    }
}
