class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res * (int) Math.pow(2, Integer.toBinaryString(i + 1).length()) + i) % 1000000007;
        }
        return (int) res;
    }
}