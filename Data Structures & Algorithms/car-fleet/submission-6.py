class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        fleets = 1
        
        positionSpeed = [[0, 0]] * len(position)
        timeTaken = [0] * len(position)
        for i in range(len(position)):
            positionSpeed[i] = [position[i], speed[i]]

        positionSpeed.sort(reverse=True) 

        for index, pair in enumerate(positionSpeed):
            timeTaken[index] = float((target - pair[0])) / pair[1]

        highest = timeTaken[0]
        for i in range(1, len(timeTaken)):
            if timeTaken[i] > highest:
                highest = timeTaken[i]
                fleets += 1
        
        return fleets
