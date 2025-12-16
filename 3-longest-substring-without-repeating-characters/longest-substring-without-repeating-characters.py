class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hs= set()
        left=0
        res=0
        for right, ch in enumerate(s):
            while ch in hs:
                hs.remove(s[left])
                left+=1
            res= max(res, right-left+1)
            hs.add(ch)
        return res
            

