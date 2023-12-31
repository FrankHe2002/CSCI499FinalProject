```java
// Runtime: 183 ms (Top 21.3%) | Memory: 40.71 MB (Top 75.1%)

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        Deque<StringBuilder> queue = new ArrayDeque();
        int ans = 0;
        queue.addLast(new StringBuilder(s));

        while (! queue.isEmpty()) {
            StringBuilder popped = queue.pollFirst();
            boolean isChange = false;
            for (int i = 0; i < popped.length() - 1; i++) {
                if (popped.charAt(i) == '0' && popped.charAt(i + 1) == '1') {
                    isChange = true;
                    popped.setCharAt(i, '1');
                    popped.setCharAt(i + 1, '0');
                    i++;
                }
            }

            if (isChange) {
                queue.addLast(popped);
                ans++;
            }
        }

        return ans;
    }
}
```