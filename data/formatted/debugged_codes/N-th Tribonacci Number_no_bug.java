class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        int p1 = 1;
        int p2 = 1;
        int p3 = 0;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = p1 + p2 + p3;
            p1 = p2;
            p2 = p3;
            p3 = cur;
        }
        return cur;
    }
}
```