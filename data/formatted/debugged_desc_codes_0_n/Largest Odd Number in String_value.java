```java
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i > -1; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) return num.substring(0, i + 1);
        }
        return "";
    }
}
```