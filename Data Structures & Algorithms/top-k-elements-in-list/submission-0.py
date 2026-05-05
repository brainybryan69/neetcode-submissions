class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqDict = {}
        for num in nums:
            freqDict[num] = 1 + freqDict.get(num, 0)

        results = sorted(freqDict.items(), key=lambda item: item[1], reverse=True)

        resultsList = []

        for i in range(0, k):
            resultsList.append(results[i][0])

        return resultsList