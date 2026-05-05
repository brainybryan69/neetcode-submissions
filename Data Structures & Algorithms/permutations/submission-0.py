class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def permutations(curr):
            if len(curr) == len(nums):
                res.append(curr.copy())
                return

            for num in nums:
                if num not in curr:
                    curr.append(num)
                    permutations(curr)
                    curr.pop()

        permutations([])    
        
        return res
            
        