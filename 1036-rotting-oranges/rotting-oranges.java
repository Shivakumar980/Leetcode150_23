class Pair {
    int first;
    int second;
    int time;

    public Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

class Solution {
    int[] delrow = { 0, 1, -1, 0 };
    int[] delcol = { 1, 0, 0, -1 };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int freshOranges=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                } else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        int t = 0;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int time = q.peek().time;
            q.poll();
            t = Math.max(t, time);
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
                        && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, time + 1));
                    visited[nrow][ncol] = 1;
                    freshOranges--;
                }

            }
        }
        //System.out.println(freshOranges);
        if (freshOranges > 0)
            return -1;
        return t;
    }
}