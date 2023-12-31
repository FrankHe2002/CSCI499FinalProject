```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] dp = new int[1001]; // Change 1000 to 1001
        for (int i : nums1) {
            dp[i]++;
        }
        int[] ans = new int[1000];

        int ptr = 0;
        for (int i : nums2) {
            if (dp[i] > 0) { // Change dp[i] == 0 to dp[i] > 0
                dp[i] = 0;
                ans[ptr] = i;
                ptr++;
            }
        }
        return Arrays.copyOfRange(ans, 0, ptr);
    }
}
```