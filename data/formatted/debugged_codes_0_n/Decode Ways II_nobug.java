```java
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int M = (int) 1e9 + 7;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= 26; j++) {
                if (j < 10 && (s.charAt(i - 1) - '0' + 'a' == j + 'a' || s.charAt(i - 1) == '*')) {
                    dp[i] += dp[i - 1];
                    dp[i] %= M;
                }
                if (i > 1 && j >= 10 && ok(j, s.substring(i - 2, i))) {
                    dp[i] += dp[i - 2];
                    dp[i] %= M;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean ok(int val, String s) {
        return (s.equals("**") && val % 10 > 0
                || s.charAt(0) == '*' && val % 10 == s.charAt(1) - '0'
                || s.charAt(1) == '*' && val / 10 == s.charAt(0) - '0' && val % 10 > 0
                || ! s.contains("*") && Integer.parseInt(s) == val);
    }
}
```