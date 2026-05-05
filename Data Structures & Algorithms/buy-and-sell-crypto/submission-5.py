class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        lowestBuy, highestSell = [0] * len(prices), [0] * len(prices)

        profit = 0

        price = prices[0]
        for i in range(len(prices)):
            if prices[i] < price:
                price = prices[i]
            lowestBuy[i] = price
            

        price = prices[-1]
        for j in range(len(prices) - 1, -1, -1):
            if prices[j] > price:
                price = prices[j]
            highestSell[j] = price
            

        for k in range(len(prices)):
            total = highestSell[k] - lowestBuy[k]
            if total > profit:
                profit = total

        return profit
            