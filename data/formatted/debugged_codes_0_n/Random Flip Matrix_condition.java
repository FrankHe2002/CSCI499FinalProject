```java
// Runtime: 51 ms (Top 47.95%) | Memory: 50.4 MB (Top 63.21%)
// Swap Tail Element Solution
// 1. Get a random number between [0, size-1]
// 2. size - 1
// 3. Get the index in map by the random map
// 4. Update the flipped element with the tail element.
// Time complexity: O(1) to init, flip, and reset
// Space complexity: O(K), where K is the times of flip calls.
class Solution {
    private final int M, N, CAPACITY;
    private int size;
    private Random random;
    private Map<Integer, Integer> map;

    public Solution(int m, int n) {
        M = m;
        N = n;
        CAPACITY = m * n;
        size = CAPACITY;
        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {
        if (size <= 0) return new int[] {-1, -1}; // fix
        int rand = random.nextInt(size); // fix
        size--;
        int idx = map.getOrDefault(rand, rand);
        int tail = map.getOrDefault(size, size); // fix
        map.put(rand, tail);
        return new int[] {idx / N, idx % N};
    }

    public void reset() {
        map.clear(); // fix
        size = CAPACITY;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
```