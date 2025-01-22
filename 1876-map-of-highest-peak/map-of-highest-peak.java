
    public class  Pair{
    
    int row;
    int col;


    public  Pair(int row, int col){
        this.row = row;
        this.col = col;
       
    }

    }
    
    class Solution {

    public int[][] highestPeak(int[][] isWater) {
        int[] dx = { 0, 0, 1, -1 }; // Horizontal movement: right, left, down, up
        int[] dy = { 1, -1, 0, 0 }; // Vertical movement corresponding to dx

        int rows = isWater.length;
        int columns = isWater[0].length;

        // Initialize the height matrix with -1 (unprocessed cells)
        int[][] cellHeights = new int[rows][columns];
        for (int[] row : cellHeights) {
            Arrays.fill(row, -1);
        }

        // Queue to perform breadth-first search
        Queue<Pair> cellQueue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                if (isWater[x][y] == 1) {
                    cellQueue.add(new Pair(x,y));
                    cellHeights[x][y] = 0;
                }
            }
        }

        int heightOfNextLayer = 1; // Initial height for land cells adjacent to water

        // Perform BFS
        while (!cellQueue.isEmpty()) {
            int layerSize = cellQueue.size();

            // Iterate through all cells in the current layer
            for (int i = 0; i < layerSize; i++) {
                Pair currentCell = cellQueue.poll();

                // Check all four possible directions for neighboring cells
                for (int d = 0; d < 4; d++) {
                    int neighborX = currentCell.row + dx[d];
                    int neighborY = currentCell.col + dy[d];

                    // Check if the neighbor is valid and unprocessed
                    if (
                        neighborX>=0 && neighborX<rows && neighborY>=0 && neighborY<columns &&
                        cellHeights[neighborX][neighborY] == -1
                    ) {
                        cellHeights[neighborX][neighborY] = heightOfNextLayer;
                        cellQueue.add(new Pair(neighborX,neighborY));
                    }
                }
            }
            heightOfNextLayer++; // Increment height for the next layer
        }

        return cellHeights;
    }

    // Function to check if a cell is within the grid boundaries
}
