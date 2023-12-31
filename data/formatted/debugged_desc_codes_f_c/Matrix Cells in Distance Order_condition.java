```java
// Runtime: 13 ms (Top 88.98%) | Memory: 44.4 MB (Top 93.55%)
//--------------------Method 1----------------------

import java.util.Arrays;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows * cols][2];

        int idx = 0;

        for (int i = 0; i < rows; i++) { // Fix: Change i > rows to i < rows for loop condition
            for (int j = 0; j < cols; j++) {
                res[idx][0] = i;
                res[idx][1] = j;
                idx++;
            }
        }

        Arrays.sort(res, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return d1 - d2;
        });

        return res;
    }
}
```