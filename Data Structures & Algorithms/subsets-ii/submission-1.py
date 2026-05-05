class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        def helper(index, curr):
            if index == len(nums):
                res.append(curr.copy())
                return

            curr.append(nums[index])
            helper(index + 1, curr)
            curr.pop()
            
            while index < len(nums) - 1 and nums[index] == nums[index + 1]:
                index += 1
            
            helper(index + 1, curr)
        

        helper(0, [])
        return res