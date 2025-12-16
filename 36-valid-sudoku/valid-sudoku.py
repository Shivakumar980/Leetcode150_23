class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        n= len(board)
        m= len(board[0])

        for i in range(n):
            hs=set()
            for j in range(m):
                if board[i][j]=='.':
                    continue
                if board[i][j] in hs:
                    return False
                hs.add(board[i][j])
        
        for i in range(m):
            hs=set()
            for j in range(n):
                if board[j][i]=='.':
                    continue
                if board[j][i] in hs:
                    return False
                hs.add(board[j][i])
        
        for box in range(9):
            hs=set()
            for i in range(3):
                for j in range(3):
                    row= (box//3 )*3+i
                    col= (box%3)*3+j
                    if board[row][col]=='.':
                        continue
                    if board[row][col] in hs:
                        return False
                    hs.add(board[row][col])
        return True


