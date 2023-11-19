```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }
        if (piles.length == h)
            return max;
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double num = 0;
            int time = 0;
            for (int i = 0; i < piles.length; i++) {
                num = (double) piles[i] / mid;
                if (num > piles[i] / (double) mid)
                    time += (int)(num) + 1; // subtle bug introduced here
                else
                    time += (int)(num);
            }
            if (time <= h) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return ans;
    }
}
```