class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def helper(index, curr, total):
            if total == target:
                res.append(curr)
                return
            elif total > target:
                return
            else:
                for j in range(index, len(nums)):
                    helper(j, curr + [nums[j]], total + nums[j])
            
        for i in range(len(nums)):
            helper(i, [nums[i]], nums[i])
        
        return res
