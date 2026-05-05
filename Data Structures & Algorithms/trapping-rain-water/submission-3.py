class Solution:
    def trap(self, height: List[int]) -> int:
        total = 0
        rightGreatest, leftGreatest = [0] * len(height), [0] * len(height)
        greatest = 0
        
        for i in range(len(height) -1, -1, -1):
            rightGreatest[i] = greatest
            if height[i] > greatest:
                greatest = height[i]

        greatest = 0

        for j in range(0, len(height)):
            leftGreatest[j] = greatest
            if height[j] > greatest:
                greatest = height[j]

        for k in range(len(height)):
            water = min(rightGreatest[k], leftGreatest[k]) - height[k]
            if water > 0:
                total += water
        
        return total
