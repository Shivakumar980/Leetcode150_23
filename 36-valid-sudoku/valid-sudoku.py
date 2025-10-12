class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n= len(board)
        m= len(board[0])

        for i in range(n):
            hs =  set()
            for j in range(m):
                if board[i][j]=='.':
                    continue
                if board[i][j] in hs:
                    return False
                hs.add(board[i][j])
            
        for j in range(m):
            hs =  set()
            for i in range(n):
                if board[i][j]=='.':
                    continue
                if board[i][j] in hs:
                    return False
                hs.add(board[i][j])


        for box in range(9):
            hs =  set()
            row= 3*(box//3)
            col= 3* (box%3)
            for i in range(row, row+3):
                for j in range(col, col+3):
                    if(board[i][j]=='.'):
                        continue
                    if board[i][j] in hs:
                        return False
                    hs.add(board[i][j])

        return True