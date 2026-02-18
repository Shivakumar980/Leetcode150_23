class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sCount=[0]*26

        for ch in s:
            sCount[ord(ch)-ord('a')]+=1
        for ch in t:
            sCount[ord(ch)-ord('a')]-=1
        for num in sCount:
            if num!=0:
                return False
        return True