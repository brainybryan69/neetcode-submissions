class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 0, max(piles)

        while left <= right:
            partition = left + (right - left + 1) // 2
            if partition == 1: return 1
            time1, time2 = 0, 0
            for i in range(len(piles)):
                time1 += math.ceil(piles[i] / (partition - 1))
                time2 += math.ceil(piles[i] / partition)
            
            if time1 > h >= time2:
                return partition
            elif h >= time1:
                right = partition
            else:
                left = partition

        
        return max(piles)
