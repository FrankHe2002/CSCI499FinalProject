```java
import java.util.*;

// Runtime: 22 ms (Top 29.13%) | Memory: 42.1 MB (Top 99.98%)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> llans = new LinkedList<>();
        if (nums == null || nums.length <= 3) {
            return llans;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length - 1;
                long ressum = target - nums[i];
                ressum = ressum - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] == ressum) {
                        List<Integer> ll = new LinkedList<>();
                        ll.add(nums[i]);
                        ll.add(nums[j]);
                        ll.add(nums[l]);
                        ll.add(nums[r]);
                        llans.add(ll);

                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < ressum) {
                        l++;
                    } else {
                        r--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }

            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }

        }
        return llans;
    }
}
```