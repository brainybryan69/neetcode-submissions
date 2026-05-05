class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()

        for i in range (0, len(nums) - 2):
            a = nums[i]
            if a > 0:
                break
            
            if i > 0 and a == nums[i - 1]:
                continue
            
            left = i + 1
            right = len(nums) - 1

            while left < right:
                total = nums[left] + nums[right] + a
                if total == 0:
                    result.append([a, nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while nums[left] == nums[left - 1] and left < right:
                        left += 1
                elif total > 0:
                    right -= 1
                else:
                    left += 1
            
        return result