class Solution:
    delrow=[0,1,-1,0]
    delcol=[-1,0,0,1]
    def numIslands(self, grid: List[List[str]]) -> int:
        n=len(grid)
        m=len(grid[0])

        visited=[[0]*m for _ in range(n)]

        res=0
        for i in range(n):
            for j in range(m):
                if visited[i][j]==0 and grid[i][j]=="1" :
                    self.dfs(i, j, visited, grid)
                    res+=1
        return res
    
    def dfs(self, row, col, visited, grid):
        visited[row][col]=1
        
        for i in range(4):
            nrow= row+ self.delrow[i]
            ncol= col +self.delcol[i]

            if(nrow>=0 and nrow < len(grid) and ncol>=0  and ncol <len(grid[0]) and visited[nrow][ncol]==0 and grid[nrow][ncol]=="1"):
                self.dfs(nrow, ncol, visited, grid)
    