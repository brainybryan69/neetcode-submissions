class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        if not s:
            return 0

        longest = 0
        left, right = 0, 0

        charSet = collections.defaultdict(int)

        while right < len(s):
            charSet[s[right]] += 1
            maxVal = max(charSet.values())
            while right - left + 1 - maxVal > k:
                    charSet[s[left]] -= 1
                    maxVal = max(charSet.values())
                    left += 1
                        
            longest = max(longest, right - left + 1)
            right += 1
        
        return longest

        
