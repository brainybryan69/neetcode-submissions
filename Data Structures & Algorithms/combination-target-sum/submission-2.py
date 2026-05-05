class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def helper(curr, total, index):
            if total == target:
                res.append(curr.copy())
                return
            elif total > target or index == len(nums):
                return
            
            num = nums[index]

            curr.append(num)
            helper(curr, total + num, index)
            curr.pop()
            helper(curr, total, index + 1)

        
        helper([], 0, 0)
       
        return res
