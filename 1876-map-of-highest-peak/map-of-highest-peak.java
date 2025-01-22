class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, -1, 0, 1};

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        // Initialize the height matrix with -1 (unprocessed cells)
        int[][] vis = new int[n][m];
        for (int[] row : vis) {
            Arrays.fill(row, -1);
        }

        // Queue to perform breadth-first search
        Queue<Pair> q = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Pair(i, j));
                    vis[i][j] = 0;  // Water cells have height 0
                }
            }
        }

        // Perform BFS
        while (!q.isEmpty()) {
            Pair p = q.poll();  // Fetch and remove the head of the queue

            int row0 = p.row;
            int col0 = p.col;
            int height = vis[row0][col0];  // Get the height of the current cell

            // Check all four possible directions for neighboring cells
            for (int i = 0; i < 4; i++) {
                int nrow = row0 + delrow[i];
                int ncol = col0 + delcol[i];

                // Check if the neighbor is valid and unprocessed
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == -1) {
                    vis[nrow][ncol] = height + 1; // Set the new cell's height
                    q.add(new Pair(nrow, ncol)); // Add to queue
                }
            }
        }

        return vis;
    }
}
