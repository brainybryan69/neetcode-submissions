class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        for point in points:
            x, y = point[0], point[1]
            distance = math.sqrt((x - 0)**2 + (y - 0)**2)
            heapq.heappush(heap, [distance, point])

        res = []
        for i in range(k):
            p = heapq.heappop(heap)
            res.append(p[1])

        return res