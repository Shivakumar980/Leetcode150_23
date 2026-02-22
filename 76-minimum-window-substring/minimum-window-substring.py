class Solution:
    def minWindow(self, s: str, t: str) -> str:

            countS,countT={},{}

            for c in t:
                countT[c]=1 + countT.get(c,0)
            
            have, need = 0, len(countT)

            l=0
            reslen=float("inf")
            res=[-1,-1]
            for r in range(len(s)):
                countS[s[r]]= 1+ countS.get(s[r],0)

                if s[r] in countT and countS[s[r]]==countT[s[r]]:
                    have+=1
                
                while have==need:

                    if r-l+1 < reslen:
                        reslen= r-l+1
                        res=[l,r]
                    
                    countS[s[l]]= countS.get(s[l],0)-1

                    if s[l] in countT and countS[s[l]]< countT[s[l]]:
                        have-=1
                
                    l+=1
            
            l,r= res

            return s[l:r+1] if reslen!=float("inf") else ""

                    
