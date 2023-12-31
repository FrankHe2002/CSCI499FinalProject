```java
// Runtime: 4 ms (Top 96.80%) | Memory: 67 MB (Top 55.57%)
class Solution {
    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE; // Changed Integer.MIN_VALUE to MAX_VALUE
        int peak = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min)
                return true;
            while (peak < nums.length && nums[i] > nums[peak])
                min = nums[peak++];
            peak--;
            nums[peak] = nums[i];
        }
        return false;
    }
}
```