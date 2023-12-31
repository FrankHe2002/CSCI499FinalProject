```java
class Solution {
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 20;

    public int strongPasswordChecker(String password) {
        int numMissingComponents = getNumberOfMissingComponents(password);
        int n = password.length();

        int numRemoval = 0;
        int over = Math.max(0, n - MAX_LENGTH);

        if (n < MIN_LENGTH) {
            return Math.max(numMissingComponents, MIN_LENGTH - n);
        }

        List<Integer> repeats = buildRepeatList(password);

        for (int i = 0; i < repeats.size(); i++) {
            int repeat = repeats.get(i);
            if (repeat >= 3 && repeat % 3 == 0 && over > 0) {
                repeats.set(i, repeat - 1);
                over--;
            }
        }

        for (int i = 0; i < repeats.size() && over > 0; i++) {
            int repeat = repeats.get(i);
            if (repeat >= 3 && repeat % 3 == 1) {
                int remove = Math.min(over, 2);
                repeats.set(i, repeat - remove);
                over -= remove;
            }
        }

        int numReplace = 0;
        for (int repeat : repeats) {
            if (repeat >= 3) {
                numReplace += repeat / 3;
            }
        }

        return Math.max(numReplace, numMissingComponents) + over + numRemoval;
    }

    private List<Integer> buildRepeatList(String password) {
        List<Integer> repeats = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            if (i == 0 || password.charAt(i) != password.charAt(i - 1)) {
                repeats.add(1);
            } else {
                int last = repeats.size() - 1;
                repeats.set(last, repeats.get(last) + 1);
            }
        }
        return repeats;
    }

    private int getNumberOfMissingComponents(String password) {
        int digit = 1;
        int upper = 1;
        int lower = 1;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digit = 0;
            }
            if (Character.isLowerCase(c)) {
                lower = 0;
            }
            if (Character.isUpperCase(c)) {
                upper = 0;
            }
        }
        return digit + upper + lower;
    }
}
```