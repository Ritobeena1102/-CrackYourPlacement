class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startX = 0, startY = 0, endX = 0, endY = 0;
        int emptyCount = 0;

        // Find start and end points, and count the empty squares
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
                if (grid[i][j] != -1) {
                    emptyCount++;
                }
            }
        }

        return dfs(grid, startX, startY, endX, endY, emptyCount);
    }

    private int dfs(int[][] grid, int x, int y, int endX, int endY, int remaining) {
        // Base case: If out of bounds or at an obstacle or already visited, return 0
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        // If reached the end point and all cells are visited
        if (x == endX && y == endY) {
            return remaining == 1 ? 1 : 0;
        }

        // Mark the cell as visited
        int temp = grid[x][y];
        grid[x][y] = -1;
        int paths = 0;

        // Explore all 4 directions
        paths += dfs(grid, x + 1, y, endX, endY, remaining - 1);
        paths += dfs(grid, x - 1, y, endX, endY, remaining - 1);
        paths += dfs(grid, x, y + 1, endX, endY, remaining - 1);
        paths += dfs(grid, x, y - 1, endX, endY, remaining - 1);

        // Backtrack: Unmark the cell
        grid[x][y] = temp;

        return paths;
    }
}
