```java
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;

        int[][] dp = new int[n + 1][target + 1];
        int mod = 1000000007;
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int x = 1; x <= k && x <= j; x++) {
                    dp[i][j] += dp[i - 1][j - x];
                    dp[i][j] %= mod;
                }
            }
        }
        return dp[n][target] % mod;
    }
}
```
