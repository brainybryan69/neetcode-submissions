class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)

        result = 0

        def helper(left, right):
            nonlocal result
            
            while left >= 0 and right < n and s[left] == s[right]:
                result += 1    
                left -= 1
                right += 1
                
            return
        
        for i in range(n):
            helper(i, i)
            helper(i, i + 1)

        return result