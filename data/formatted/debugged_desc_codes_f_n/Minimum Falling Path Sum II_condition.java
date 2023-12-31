```java
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = 10000000;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, grid[0][i] + helper(grid, n, 1, i, dp));
        }
        return ans;
    }

    private int helper(int[][] grid, int n, int i, int last, int[][] dp) {
        if (i == n - 1) {
            int min = 100;
            for (int k = 0; k < n; k++) {
                if (k != last) {
                    min = Math.min(grid[n - 1][k], min);
                }
            }
            return min;
        }
        if (dp[i][last] != -1) return dp[i][last];
        int min = 100000000;
        for (int k = 0; k < n; k++) {
            if (k != last) {
                min = Math.min(min, grid[i][k] + helper(grid, n, i + 1, k, dp));
            }
        }

        dp[i][last] = min;
        return dp[i][last];
    }
}
```