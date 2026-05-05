class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for i in range(len(stones)):
            heapq.heappush(heap, -stones[i])
        
        while len(heap) > 1:    
            stone1 = -heapq.heappop(heap)
            stone2 = -heapq.heappop(heap)
            if stone1 == stone2:
                continue
            else:
                heapq.heappush(heap, stone2 - stone1)

        if heap:
            return -heap[0]

        return 0