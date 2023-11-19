```java
// Runtime: 11 ms (Top 93.9%) | Memory: 44.11 MB (Top 57.7%)

class Solution {
    int[] memo;
    int[] nums;
    int numSlots;

    public int maximumANDSum(int[] nums, int numSlots) {
        this.memo = new int[1 << (2 * numSlots)];
        this.nums = nums;
        this.numSlots = numSlots;
        return helper(0, 0);
    }

    int helper(int numIndex, int set) {
        if (numIndex == nums.length) return 0;
        if (memo[set] > 0) return memo[set] - 1;
        int max = 0;
        for (int i = 0; i < numSlots; i++) {
            int firstHalfSlot = (set & (1 << i)) == 0 ? i : -1;
            int secondHalfSlot = (set & (1 << (i + numSlots))) == 0 ? i + numSlots : -1;
            int slotChosen = firstHalfSlot > -1 ? firstHalfSlot : secondHalfSlot;
            if (slotChosen < 0) continue;
            int andSum = 0;
            if (slotChosen >= numSlots) andSum = ((slotChosen - numSlots) + 1) & nums[numIndex];
            else andSum = (slotChosen + 1) & nums[numIndex];
            max = Math.max(max, andSum + helper(numIndex + 1, set | 1 << slotChosen));
        }
        memo[set] = max + 1;
        return max;
    }
}
```