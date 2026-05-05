class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res, part = [], []
        
        def helper(i, j):
            if j >= len(s):
                if j == i:
                    res.append(part.copy())
                return
            
            if self.isPalindrome(s, i, j):
                part.append(s[i : j + 1])
                helper(j + 1, j + 1)
                part.pop()

            helper(i, j + 1)
        
        helper(0, 0)
        return res


    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l, r = l + 1, r - 1
        return True
