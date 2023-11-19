```java
class Solution {
    boolean first = false;

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != (s.charAt(right))) {
                if (!first) {
                    first = true;
                    String removeLeft = s.substring(0, left).concat(s.substring(left + 1));
                    String removeRight = s.substring(0, right).concat(s.substring(right + 1));
                    return validPalindrome(removeLeft) || validPalindrome(removeRight);
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
}
```