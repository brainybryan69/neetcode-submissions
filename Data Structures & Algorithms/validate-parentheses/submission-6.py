class Solution:
    def isValid(self, s: str) -> bool:
        
        stack = []
        openClose = {"(" : ")", "[" : "]", "{" : "}"}
        

        for i in range(len(s)):
            char = s[i]
            if char in openClose:
                stack.append(char)
            else:
                if not stack:
                    return False
                openChar = stack.pop()
                if openClose[openChar] != char:
                    return False
        
        if stack: return False

        return True

        