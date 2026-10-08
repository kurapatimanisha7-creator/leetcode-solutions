class Solution:
    def firstUniqChar(self, s: str) -> int:
        freq={ }
        for c in s:
            if c in freq:
                freq[c]+=1
            else:
                freq[c]=1
        for ch in freq:
            if freq[ch]==1:
                return s.index(ch)
        return -1


        
        