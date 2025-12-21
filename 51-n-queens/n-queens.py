class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        res=[]
        board=[["."]*n for _ in range(n)]

        col=set()
        posDiag=set()
        negDiag=set()

        def backtrack(r):
            if r==n:
                part=["".join(row) for row in board]
                res.append(part)
                return 

            for c in range(0, n):
                if  c in col or r-c in posDiag or r+c in negDiag:
                    continue
                
                col.add(c)
                posDiag.add(r-c)
                negDiag.add(r+c)
                board[r][c]='Q'

                backtrack(r+1)

                col.remove(c)
                posDiag.remove(r-c)
                negDiag.remove(r+c)
                board[r][c]='.'
        backtrack(0)

        return res
        