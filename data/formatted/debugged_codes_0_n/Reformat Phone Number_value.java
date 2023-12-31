```java
class Solution {
    public String reformatNumber(String number) {
        String modifiedNumber = number.replace(" ", "").replace("-", "");
        int l = modifiedNumber.length();
        if (l <= 3) {
            return modifiedNumber;
        } else if (l == 4) {
            return modifiedNumber.substring(0, 2) + "-" + modifiedNumber.substring(2, 4);
        } else {
            modifiedNumber = modifiedNumber.substring(0, 3) + "-" + reformatNumber(modifiedNumber.substring(3));
        }
        return modifiedNumber;
    }
}
```