class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        string = ""
        for _ in range(n):
            string += "."
        board = [string for _ in range(n)]
        
        def backtrack(curr_board, row):
            if row == n:
                result.append(curr_board[:])
            
            for col in range(n):
                if isSafe(curr_board, row, col):
                    string = curr_board[row]
                    helper_list = list(string)
                    helper_list[col] = "Q"
                    string = "".join(helper_list)

                    new_board = curr_board[:]
                    new_board[row] = string
                    backtrack(new_board, row + 1)
            
        def isSafe(curr_board, row, col):
            if row == 0:
                return True

            for i in range(row):
                if curr_board[i][col] == "Q":
                    return False

                if col + row - i < n:
                    if curr_board[i][col + row - i] == "Q":
                        return False
                
                if col - row + i >= 0:    
                    if curr_board[i][col - row + i] == "Q":
                        return False

            return True
                
        backtrack(board, 0)
        return result