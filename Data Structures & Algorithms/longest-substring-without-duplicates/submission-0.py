class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s: return 0

        if len(s) == 1: return 1

        charSet = set()
        charSet.add(s[0])
        
        longest = 1
        left = 0
        right = 1

        while right < len(s):
            if s[right] not in charSet:
                charSet.add(s[right])
                right += 1
                longest = max(longest, right - left)
            else:
                if s[left] == s[right]:
                    left += 1
                    right += 1
                else:
                    charSet.remove(s[left])
                    left += 1

                

        return longest