class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        seen = {}
        def helper(left, right):
            if (left, right) in seen:
                return seen[(left, right)]

            if right >= len(s):
                return left == len(s)
            
            if s[left : right + 1] in wordDict:
                seen[(left, right)] = True
                return helper(right + 1, right + 1) or helper(left, right + 1)
            seen[(left, right)] = False
            return helper(left, right + 1)
        
        return helper(0, 0)