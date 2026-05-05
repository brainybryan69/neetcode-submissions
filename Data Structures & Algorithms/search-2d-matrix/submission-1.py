class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        top, bot = 0, len(matrix) - 1
        while top <= bot:
            index = top + (bot - top) // 2
            if matrix[index][0] > target:
                bot = index - 1
            elif matrix[index][-1] < target:
                top = index + 1
            else:
                break
        
        if not (top <= bot):
            return False

        row = top + (bot - top) // 2
        
        left, right = 0, len(matrix[row]) - 1
        while left <= right:
            index = left + (right - left) // 2
            if matrix[row][index] == target:
                return True
            elif matrix[row][index] > target:
                right = index - 1
            else:
                left = index + 1
        
        return False
        