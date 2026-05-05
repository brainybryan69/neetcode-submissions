class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operations = {
            "+" : lambda x, y: x + y, 
            "-" : lambda x, y: y - x, 
            "*" : lambda x, y: x * y, 
            "/" : lambda x, y: int(float(y) / x)
        }
        for c in tokens:
            if c not in operations:
                stack.append(int(c))
            else:
                arg1 = stack.pop()
                arg2 = stack.pop()
                result = operations[c](arg1, arg2)
                stack.append(result)

        return stack[0]
