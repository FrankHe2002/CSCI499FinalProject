```java
// Runtime: 12 ms (Top 87.36%) | Memory: 75.4 MB (Top 41.15%)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int odd = 0;
        int result = 0;
        int temp = 0;

        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                odd++;
                temp = 0;
            }
            while (odd == k) {
                temp++;
                if (nums[i] % 2 != 0)
                    odd--;
                i++;
            }
            result += temp;
            j++;

        }
        return result;
    }
}
```