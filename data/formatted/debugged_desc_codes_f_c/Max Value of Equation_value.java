```java
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int f = 1;
        while (i < points.length) {
            if (f <= i)
                f = i + 1;
            for (int j = f; j < points.length; j++) {
                if (points[j][0] > (points[i][0] + k))
                    break;
                if ((points[i][1] + points[j][1] + points[j][0] - points[i][0]) > ans) {
                    ans = points[i][1] + points[j][1] + points[j][0] - points[i][0];
                    f = j;
                }
            }
            i++;
        }
        return ans;
    }
}
```