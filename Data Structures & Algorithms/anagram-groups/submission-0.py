class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        def isAnagram(s: str, t: str) -> bool:
            if len(s) != len(t):
                return False
            dict_s = {}
            dict_t = {}
            
            for i in range (0, len(s)):
                dict_s[s[i]] = 1 + dict_s.get(s[i], 0)
                dict_t[t[i]] = 1 + dict_t.get(t[i], 0)    

            return dict_s == dict_t
        
        result = []

        while strs:
            currentStr = strs.pop(0)
            anagramList = [currentStr]

            i = len(strs) - 1
            while i >= 0:
                if isAnagram(strs[i], currentStr):
                    anagramList.append(strs.pop(i))
                i -= 1

            result.append(anagramList)

        return result

