```java
// Runtime: 9 ms (Top 61.9%) | Memory: 44.46 MB (Top 5.0%)

import java.util.Arrays;

class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        return nums[1];
    }
}
```