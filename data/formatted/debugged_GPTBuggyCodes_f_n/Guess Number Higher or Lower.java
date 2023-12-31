```java
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = ((right - left) / 2) + left;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```