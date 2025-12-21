class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        res=[]
        def dfs( index, part):
            if index==len(s):
                res.append(part.copy())
                return res
            
            for j in range(index, len(s)):
                if self.isPalindrome(s, index, j):
                    part.append(s[index:j+1])
                    dfs(j+1, part)
                    part.pop()
        dfs(0,[])
        return res
            
    def isPalindrome(self,s, start, end):
        while( start< end):
            if s[start]!= s[end]:
                return False
            start+=1
            end-=1
        return True