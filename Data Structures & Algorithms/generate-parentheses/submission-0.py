class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        
        def stringBuilder(o, c, s):
            if o == n and c == n:
                result.append(s)
            elif o == n:
                stringBuilder(o, c + 1, s + ")")
            elif o > c:
                stringBuilder(o + 1, c, s + "(")
                stringBuilder(o, c + 1, s + ")")
            else:
                stringBuilder(o + 1, c, s + "(")
        
        stringBuilder(0, 0, "")
        return result