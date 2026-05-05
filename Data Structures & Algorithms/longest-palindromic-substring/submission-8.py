class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 1:
            return s
        
        result = ""

        isPalindrome = []

        def helper(left, right):
            nonlocal result
            
            if (left, right) in isPalindrome:
                return helper(left - 1, right + 1)
            
            if left < 0 or right >= n:
                return
            
            if s[left] == s[right]:
                isPalindrome.append((left, right))
                result_length = len(result)
                curr_length = right - left + 1
                if curr_length > result_length:
                    result = s[left: right + 1]

                return helper(left - 1, right + 1)
            return
        
        for i in range(n):
            helper(i, i)
            helper(i, i + 1)

        return result