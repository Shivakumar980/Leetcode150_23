class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowmap=defaultdict(set)
        colmap=defaultdict(set)
        boxmap=defaultdict(set)

        for row in range(9):
            for col in range(9):
                if board[row][col]=='.':
                    continue
                else:
                    if(board[row][col] in rowmap[row] or board[row][col] in colmap[col] or board[row][col] in boxmap[(row//3,col//3)]):
                        return False
                    rowmap[row].add(board[row][col])
                    colmap[col].add(board[row][col])
                    boxmap[(row//3,col//3)].add(board[row][col])
        return True