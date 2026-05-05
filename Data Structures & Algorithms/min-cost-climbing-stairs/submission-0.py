class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        minCostArr = [0] * (n + 1)

        for i in range(2, n + 1):
            minCostArr[i] = min(
                            minCostArr[i - 1] + cost[i - 1],
                            minCostArr[i - 2] + cost[i - 2])
        return minCostArr[n]