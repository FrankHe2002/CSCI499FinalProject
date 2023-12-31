The bug in the provided Java code is in Approach 3: Cyclic Sort. 

In this approach, we are attempting to sort the array by placing each number at its correct index. However, there is an error in the swap method. The arguments for swapping are the current index `i` and the value at index `nums[i]`, but it should be the value at index `i` and the value at index `nums[i]`. 

To fix the bug, we need to change the arguments in the swap method. 

Here is the corrected Java code:

```java
// Approach 1: Find diff

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums)
            expectedSum -= num;
        return expectedSum;
    }
}

// Approach 2: XOR
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        for (int i = 1; i <= nums.length; i++)
            xor1 = xor1 ^ i;

        int xor2 = 0;
        for (int num : nums)
            xor2 = xor2 ^ num;
        return xor1 ^ xor2;
    }
}

// Approach 3: Cyclic sort
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i && nums[i] < nums.length)
                swap(i, nums[i], nums);
            else
                i += 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j)
                return j;
        }
        return nums.length;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

Note: The other two approaches (Find diff and XOR) do not have any bugs.