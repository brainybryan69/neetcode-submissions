class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
            
        sortedArr = sorted(nums)
        
        length = 1
        longest = 1
        current = sortedArr[0]
        
        for i in range(1, len(sortedArr)):
            if sortedArr[i] - 1 == current:
                length += 1
                longest = max(length, longest)
            elif sortedArr[i] == current:
                continue
            else:
                length = 1
            current = sortedArr[i]
        return longest
        