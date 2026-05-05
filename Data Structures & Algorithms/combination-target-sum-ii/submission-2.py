class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
            
        def helper(index, total, curr):
            if total == target:
                res.append(curr.copy())
                return
            
            if index >= len(candidates) or total > target:
                return
            
            curr.append(candidates[index])
            helper(index + 1, total + candidates[index], curr)    
            curr.pop()

            while index + 1 < len(candidates) and candidates[index] == candidates[index + 1]:
                index += 1
        
            helper(index + 1, total, curr)
        
        helper(0, 0, [])
        
        return res
