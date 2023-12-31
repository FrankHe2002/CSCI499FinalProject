```java
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // every row prefix sum
        int[][] rowPrefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            rowPrefix[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                rowPrefix[i][j] = rowPrefix[i][j - 1] + grid[i][j];
            }
        }

        // every column prefix sum
        int[][] columnPrefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            columnPrefix[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                columnPrefix[i][j] = columnPrefix[i][j - 1] + grid[i][j];
            }
        }

        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // length of square
                int l = Math.min(m - i, n - j);
                // only check square's length is better than previous result
                for (int k = l; k > result; k--) {
                    if (magic(i, j, k, grid, rowPrefix, columnPrefix)) {
                        result = k;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean magic(
            int i, int j, int l, int[][] grid, int[][] rowPrefix, int[][] columnPrefix) {
        // check every row
        int target = rowPrefix[i][j + l - 1] - (j > 0 ? rowPrefix[i][j - 1] : 0) + grid[i][j];
        for (int k = 0; k < l; k++) {
            if (rowPrefix[i + k][j + l - 1] - (j > 0 ? rowPrefix[i + k][j - 1] : 0) + grid[i + k][j] != target) {
                return false;
            }
        }

        // check every column
        for (int k = 0; k <