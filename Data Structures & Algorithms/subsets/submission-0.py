class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def helper(index):
            if index == len(nums):
                return [[]]
            
            subsets_without = helper(index + 1)

            subsets_with = []
            for subset in subsets_without:
                subsets_with.append(subset + [nums[index]])

            return subsets_without + subsets_with
        
        return helper(0)

            

        