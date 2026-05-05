class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []

        def helper(curr, num_open):
            
            if len(curr) == 2 * n:
                result.append(curr[:])
                return
            
            num_close = len(curr) - num_open
            if num_close > num_open:
                return
            elif num_close == num_open:
                helper(curr + '(', num_open + 1)
            else:
                if num_open < n:
                    helper(curr + '(', num_open + 1)
                helper(curr + ')', num_open)
        
        helper('(', 1)

        return result