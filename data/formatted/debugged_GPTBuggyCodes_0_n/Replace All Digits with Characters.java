```java
class Solution {
    public String replaceDigits(String s) {
        char[] str = s.toCharArray();

        for (int i = 1; i < str.length; i += 2) { // Fixed the loop condition to start from 1 instead of 0
            if (Character.isDigit(str[i])) {
                str[i] = shift(str[i - 1], str[i]);
            }
        }
        return String.valueOf(str);
    }

    char shift(char letter, char number) {
        int a = Integer.parseInt(String.valueOf(number));
        int asci = (int) letter;
        char c = (char) (asci + a);
        return c;
    }
}
```
