// Runtime: 526 ms (Top 46.46/) | Memory: 54.8 MB (Top 85.59%)
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        if (nums.length == 0)
            return new int[0];

        int[] result = new int[queries.length];
        int strLen = nums[0].length();
        int[] index = new int[1];

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            for (int i = index[0]; i < strLen; i++) {
                if (nums[a].charAt(i) != nums[b].charAt(i)) {
                    return nums[a].charAt(i) - nums[b].charAt(i); // Fix bug: Return the difference between characters instead of reversed order.
                }
            }

            return a - b; // Fix bug: Return a - b instead of b - a to maintain original order for tied characters.
        });

        for (int i = 0; i < queries.length; i++) {
            index[0] = strLen - queries[i][1];
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