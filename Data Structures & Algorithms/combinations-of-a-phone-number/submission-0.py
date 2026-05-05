class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {
            "2":"abc",
            "3":"def",
            "4":"ghi",
            "5":"jkl",
            "6":"mno",
            "7":"pqrs",
            "8":"tuv",
            "9":"wxyz"
        }

        res = []

        def helper(s, i):
            if i >= len(digits):
                res.append(s)
                return
            
            char = digits[i]
            values = mapping[char]
            for c in values:
                helper(s + c, i + 1)
        
        if not digits:
            return res
        helper("", 0)
        return res
        