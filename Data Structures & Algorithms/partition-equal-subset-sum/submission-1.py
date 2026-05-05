class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)

        if total % 2:
            return False
        
        target = total // 2

        dp = {0}

        for num in nums:
            dp = {s + num for s in dp} | dp
        
        return target in dp