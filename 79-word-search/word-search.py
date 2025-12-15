class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n=len(board)
        m=len(board[0])

        visited=[[0]*m for _ in range(n)]
        directions=[(1,0),(0,1),(-1,0),(0,-1)]

        def dfs(row, col, index, word, board):
            if index == len(word):
                return True
            visited[row][col]=1

            for r, c in directions:
                nrow= r+row
                ncol= c+col
                if(0<= nrow< n and 0<= ncol< m and visited[nrow][ncol]==0 and word[index]==board[nrow][ncol]) :
                    if dfs(nrow, ncol, index+1, word, board):
                        return True
            visited[row][col]=0
            return False
            


        for i in range(n):
            for j in range(m):
                if board[i][j]== word[0]:
                    if dfs(i, j, 1, word, board) :
                        return True
        
        return False
                    


        