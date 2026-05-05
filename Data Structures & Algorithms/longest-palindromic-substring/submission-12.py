class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 1:
            return s
        
        result = [0, 0]

        def helper(left, right):
            nonlocal result
            
            while left >= 0 and right < n and s[left] == s[right]:    
                left -= 1
                right += 1
                
            if right - left - 2 > result[1] - result[0]:
                result[0], result[1] = left + 1, right - 1

            return
        
        for i in range(n):
            helper(i, i)
            helper(i, i + 1)

        return s[result[0] : result[1] + 1]