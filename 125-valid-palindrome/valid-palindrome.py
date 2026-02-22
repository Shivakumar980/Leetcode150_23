class Solution:
    def isPalindrome(self, s: str) -> bool:
        st=""
        for i,ch in enumerate(s):
            if ch.isalpha() or ch.isdigit():
                st+=ch.lower()
        
        l,r= 0,len(st)-1

        while(l<=r):
            if st[l]!=st[r]:
                return False
            l+=1
            r-=1
        return True
        
            
