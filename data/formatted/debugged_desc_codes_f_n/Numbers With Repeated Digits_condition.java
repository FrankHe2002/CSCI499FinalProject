```java
// Runtime: 1 ms (Top 98.74%) | Memory: 41.1 MB (Top 50.94%)
class Solution {
    public int numDupDigitsAtMostN(int n) {
        int ttl = n++;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        for (int i = 1; i < list.size(); i++) {
            ans += 9 * find(i - 1, 9);
        }
        boolean[] seen = new boolean[10];
        for (int i = list.size(), d = 9; i > 0; --i, d--) {
            int count = i != list.size() ? list.get(i - 1) - 1 : list.get(i - 1);
            for (int j = 0; j < list.get(i - 1); j++) {
                if (seen[j]) {
                    count--;
                }
            }
            ans += count * find(i - 1, d);
            if (seen[list.get(i - 1)]) {
                break;
            }
            seen[list.get(i - 1)] = true;
        }
        return ttl - ans;
    }

    private int find(int n, int d) {
        long ans = 1;
        // Calculate dCn by dividing d! by (d-n)!
        for (int i = 1; i <= d; i++) {
            ans *= i;
        }
        for (int i = n + 1; i <= d; i++) {
            ans /= (i - n);
        }
        return (int) ans;
    }
}
```