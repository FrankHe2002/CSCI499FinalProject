```java
class Solution {
    public int mod = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;

        long mx = (long) (Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm / 2;
        long sum = rec(sm, n);

        return (int) (sum * (mx % mod) % mod);
    }

    public long rec(long val, long n) {
        if (n == 0) return 1;
        if (n == 1) return (val % mod);

        long newVal = powMod(val % mod, 2) % mod;

        if (n % 2 != 0) {
            return (rec(newVal, n / 2) % mod) * (val % mod) % mod;
        }

        return rec(newVal, n / 2) % mod;
    }
    
    public long powMod(long base, long exp) {
        long result = 1;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            
            base = (base * base) % mod;
            exp /= 2;
        }
        
        return result;
    }
}
```