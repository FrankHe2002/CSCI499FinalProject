```java
// Runtime: 1 ms (Top 99.09%) | Memory: 42.9 MB (Top 55.32%)
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int theHighest = candies[0];
        for (int i = 1; i < candies.length; i++) {
            theHighest = Math.max(theHighest, candies[i]);
        }
        int mathLogic = theHighest - extraCandies;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= mathLogic) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
```