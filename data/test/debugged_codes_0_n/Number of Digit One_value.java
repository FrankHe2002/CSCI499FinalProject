class Solution {
    int max(int a, int b){
        if(a > b)
            return a;
        else
            return b;
    }

    int min(int a, int b){
        if(a < b)
            return a;
        else
            return b;
    }

    public int countDigitOne(int n) {
        int c = 0;
        for(int i = 1; i <= n; i *= 10){
            int divider = i * 10;
            c += (n / divider) * i + min(max((n % divider - i + 1), 1), i);
        }
        return c;
    }
}

// T.C.  - O(log n)