class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = 0, 0
        
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
            
        pointer = 0
        while True:
            slow = nums[slow]
            pointer = nums[pointer]
            if slow == pointer:
                return slow
        
        
