class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        BOTTOM_MAX = len(board)
        RIGHT_MAX = len(board[0])
        
        def helper(index, curr, used):
            i = curr[0]
            j = curr[1]

            if used and curr in used:
                return False

            if index + 1 == len(word):
                if board[i][j] == word[index]:
                    return True

            if board[i][j] == word[index]:
                index += 1
                if i > 0:
                    copy = used.copy()
                    copy.append(curr)
                    if helper(index, [i - 1, j], copy):
                        return True
                if i < BOTTOM_MAX - 1:
                    copy = used.copy()
                    copy.append(curr)
                    if helper(index, [i + 1, j], copy):
                        return True
                if j > 0:
                    copy = used.copy()
                    copy.append(curr)
                    if helper(index, [i, j - 1], copy):
                        return True
                if j < RIGHT_MAX - 1:
                    copy = used.copy()
                    copy.append(curr)
                    if helper(index, [i, j + 1], copy):
                        return True

        for i in range(BOTTOM_MAX):
            for j in range(RIGHT_MAX):
                if helper(0, [i, j], []):
                    return True
        
        return False
            