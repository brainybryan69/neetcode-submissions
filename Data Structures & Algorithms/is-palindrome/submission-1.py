class Solution:
    def isPalindrome(self, s: str) -> bool:
        result = ''.join(char.lower() for char in s if char.isalnum())
        
        left = 0
        right = len(result) - 1
        
        while left <= right:
            if result[left] != result[right]:
                return False
            left += 1
            right -= 1

        return True