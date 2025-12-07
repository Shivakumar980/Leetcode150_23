class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n= len(grid)
        m= len(grid[0])

        visited= [[0]*m for _ in range(n)]

        def bfs(visited, grid, row, col):
            n= len(grid)
            m= len(grid[0])
            visited[row][col]=1
            q= deque()
            q.append((row, col))
            directions= [(1,0),(0,1),(-1,0),(0,-1)]

            while q:
                nr, nc = q.popleft()
                visited[row][col]=1

                for r,c in directions:
                    nrow= r+nr
                    ncol= c+nc

                    if(0<=nrow< n and 0<= ncol <m and grid[nrow][ncol]=="1" and visited[nrow][ncol]==0):
                        visited[nrow][ncol]=1
                        q.append((nrow,ncol))


        res=0
        for i in range(n):
            for j in range(m):
                if visited[i][j]==0 and grid[i][j]=="1":
                    bfs(visited, grid, i, j )
                    res+=1
        return res
        