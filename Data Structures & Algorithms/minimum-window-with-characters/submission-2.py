class Solution:
    def minWindow(self, s: str, t: str) -> str:
        result, resLen = [-1, -1], float('inf')
        
        sSet = collections.defaultdict(int)
        tSet = collections.defaultdict(int)

        for c in t:
            tSet[c] += 1 

        left = 0
        have, need = 0, len(tSet)

        for r in range(len(s)):
            c = s[r]
            sSet[c] += 1

            if c in tSet and sSet[c] == tSet[c]:
                have += 1
            
            while have == need:
                if (r - left + 1) < resLen:
                    result = [left, r]
                    resLen = r - left + 1
                
                sSet[s[left]] -= 1

                if s[left] in tSet and sSet[s[left]] < tSet[s[left]]:
                    have -= 1
                left += 1
        
        return s[result[0]:result[1] + 1] if resLen != float('inf') else ""


        