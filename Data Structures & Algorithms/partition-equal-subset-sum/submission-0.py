class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)

        if total % 2:
            return False
        
        total /= 2

        def helper(index, curr_total):
            if index >= len(nums):
                return curr_total == total
            else:
                return helper(index + 1, curr_total) or helper(index + 1, curr_total + nums[index])

        return helper(0, 0)