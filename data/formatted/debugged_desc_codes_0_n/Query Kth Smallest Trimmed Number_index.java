```java
// Runtime: 526 ms (Top 46.46%) | Memory: 54.8 MB (Top 85.59%)
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        if (nums.length == 0)
            return new int[0];

        int[] result = new int[queries.length];
        int strLen = nums[0].length();        

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            for (int i = strLen - queries[0][1]; i < strLen; i++) {
                if (nums[a].charAt(i) != nums[b].charAt(i))
                    return nums[b].charAt(i) - nums[a].charAt(i);
            }

            return b - a;
        });

        for (int i = 0; i < queries.length; i++) {
            queue.clear();

            for (int j = 0; j < nums.length; j++) {
                queue.add(j);
                if (queue.size() > queries[i][0])
                    queue.poll();
            }

            result[i] = queue.poll();
        }

        return result;
    }
}
```