```java
class Solution {
    int[][] dp;
    int[] dirs = new int[] {-1, 0, 1};
    int m, n, max = 0;

    private int maxMoves(int[][] grid, int x, int y) {
        if (y == n - 1) return 0;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int dir : dirs) {
            int x2 = x + dir;
            if (x2 < 0 || x2 == m) continue;

            if (grid[x2][y + 1] >= grid[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + maxMoves(grid, x2, y + 1));
            }
        }
        return dp[x][y];
    }

    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            max = Math.max(max, maxMoves(grid, i, 0));
        }

        return max;
    }
}
```