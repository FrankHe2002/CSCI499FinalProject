Bug type: IndexOutOfBounds exception

Reasoning process:
1. The code loops from 0 to `arr.length` (inclusive) in line 16.
2. The index `i` is used to access `arr[i]` in line 17 and `arr.get(arr[i])` in line 21.
3. If `i` reaches `arr.length`, an IndexOutOfBounds exception will be thrown because `arr[i]` will be out of bounds.

Fix:
Change `i <= arr.length` to `i < arr.length` in line 16 to prevent the IndexOutOfBounds exception.

Corrected code:
```java
// Runtime: 98 ms (Top 85.00%) | Memory: 59.9 MB (Top 96.25%)
class Solution {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {  // Fix: Change "<=" to "<"
            if (! map.containsKey(arr[i])) {
                continue;
            }

            array.add(map.get(arr[i]));
        }

        int maxLen = 0;
        int[] tails = new int[n + 1];

        for (int i = 0; i < n; i++) {
            tails[i] = -1;
        }

        for (int num : array) {
            int index = findMinIndex(tails, maxLen, num);

            if (tails[index] == -1) {
                maxLen++;
            }
            tails[index] = num;
        }

        return n - maxLen;
    }

    public int findMinIndex(int[] tails, int n, int val) {
        int low = 0;
        int ans = n;
        int high = n - 1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (tails[mid] >= val) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
```