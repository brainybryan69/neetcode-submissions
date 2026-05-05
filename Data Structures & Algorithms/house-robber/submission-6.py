class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0], nums[1])

        total_arr = [0] * n
        total_arr[0], total_arr[1] = nums[0], nums[1]
        
        
        for i in range(2, n):
            if i == 2:
                total_arr[i] = nums[i] + total_arr[i - 2]
            else:
                total_arr[i] = nums[i] + max(total_arr[i - 2], total_arr[i - 3])
        
        return max(total_arr[n - 1], total_arr[n - 2])