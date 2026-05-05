class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result = []
        heap = []

        for i in range(k):
            heapq.heappush(heap, -nums[i])
        
        result.append(-heap[0])

        l = 0
        for r in range(k, len(nums)):
            heap.remove(-nums[l])
            l += 1
            heapq.heappush(heap, -nums[r])
            heapq.heapify(heap)
            result.append(-heap[0])
        
        return result
        
            