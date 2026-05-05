class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]

        random =[1] * n * 100
        total_arr = [0] * n
        total_arr[0], total_arr[1] = nums[0], max(nums[0], nums[1])
        
        
        for i in range(2, n):
            total_arr[i] = max(
                total_arr[i - 1],
                nums[i] + total_arr[i - 2])
        
        return total_arr[-1]