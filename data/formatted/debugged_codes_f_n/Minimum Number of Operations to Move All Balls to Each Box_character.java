Buggy Code Fix:
```java
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                char c = boxes.charAt(j);
                if (c == '1') t += Math.abs(i - j);
            }
            ans[i] = t;
        }
        return ans;
    }
}
```