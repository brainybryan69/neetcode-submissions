class LRUCache:

    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity = capacity
        self.counter = 0
        

    def get(self, key: int) -> int:
        if key in self.cache:
            self.counter += 1
            self.cache[key][0] = self.counter
            return self.cache[key][1]
        return -1
        

    def put(self, key: int, value: int) -> None:
        self.counter += 1
        if key in self.cache:
            self.cache[key] = [self.counter, value]
            return
            
        if len(self.cache) == self.capacity:
            index, least = None, float('inf')
            for k in self.cache:
                if self.cache[k][0] < least:
                    index = k
                    least = self.cache[k][0]
            self.cache.pop(index)

        self.cache[key] = [self.counter, value]
        
