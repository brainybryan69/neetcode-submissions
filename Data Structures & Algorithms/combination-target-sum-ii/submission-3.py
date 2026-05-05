class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
            
        def helper(index, total, curr):
            if total == target:
                res.append(curr.copy())
                return
            elif total > target or index >= len(candidates):
                return

            num = candidates[index]
            i = index

            curr.append(num)
            helper(index + 1, total + num, curr)
            curr.pop()
            while i < len(candidates) and candidates[i] == num:
                i += 1
            if i >= len(candidates):
                return
            helper(i, total, curr)
        
        helper(0, 0, [])
        
        return res
