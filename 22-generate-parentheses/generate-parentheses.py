class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        res=[]
        def generate(open, close,part):
            if open==n and close==n:
                res.append(part)
                return

            if(open< n):
                generate(open+1, close, part+'(')
            if(close< open):
                generate(open, close+1, part+")")
        generate(0,0,"")
        return res

                