class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        time = 0
        heap = []
        queue = deque()
        
        data = collections.defaultdict(int)
        for task in tasks:
            data[task] += 1
        
        for k, v in data.items():
            heapq.heappush(heap, -v)

        

        while heap or queue:
            time += 1

            if not heap:
                time = queue[0][1]
            else:
                count = heapq.heappop(heap) + 1
                if count:
                    queue.append((count, time + n))
            
            if queue and queue[0][1] == time:
                qelem = queue.popleft()
                heapq.heappush(heap, qelem[0])
            
            
                
        
        return time